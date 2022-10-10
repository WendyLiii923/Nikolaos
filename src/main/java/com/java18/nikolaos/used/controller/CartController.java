package com.java18.nikolaos.used.controller;

import static com.java18.nikolaos.used.model.service.impl.ProductServiceImpl.PRODUCT_STATUS_PUBLISHED;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.view.RedirectView;

import com.java18.nikolaos.used.model.Members;
import com.java18.nikolaos.used.model.ProductInfoView;
import com.java18.nikolaos.used.model.UsedCart;
import com.java18.nikolaos.used.model.service.CartService;
import com.java18.nikolaos.used.model.service.CategoryService;
import com.java18.nikolaos.used.model.service.ProductService;

@Controller
@SessionAttributes("loginMember")
@RequestMapping("/CartService")
public class CartController {
	
	@Autowired
	CartService cartService;
	@Autowired
	CategoryService categoryService;
	@Autowired
	ProductService productService;
	
	@RequestMapping("/removeFromCart")
	public RedirectView add(Model model,
						@RequestParam(required = false) Integer memberId,
						@RequestParam(required = false) Integer productId
	) {
		UsedCart getCart = cartService.getUncheckOutCart(memberId);
		cartService.deleteProductFromCart(memberId, getCart.getId(), productId);
		model.addAttribute("cartDetailList",cartService.getCartDetailList(getCart.getId()));
		model.addAttribute("cartInfoList", cartService.getCartDetailInfo(getCart.getId()));
		model.addAttribute("categoryList", categoryService.getCategoryList());
		String url = "/nikolaos/CartService/showCart?memberId="+ memberId;
		return new RedirectView(url);
	}
	
	@PostMapping(path = "/addCart", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public ResponseEntity<Map<String, String>> addProductToCart(
			@RequestParam Integer productId,
			@RequestParam(defaultValue = "1") Integer productQty,
			@SessionAttribute("loginMember") Members member
			) {
		Map<String, String> map;
		map = checkProductAndMemberStatus(productId, member.getId());
		if (map.containsKey("success")) {
			UsedCart uncheckOutCart = cartService.getUncheckOutCart(member.getId());
			return ResponseEntity.ok(cartService.addToCart(uncheckOutCart.getId(), productId, productQty));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
	}
	
    private Map<String, String> checkProductAndMemberStatus(Integer productId, Integer memberId){
        HashMap<String, String> map = new HashMap<>();
        if(memberId == null){
            map.put("fail","使用者未登入");
            return map;
        }
        if(productId == null){
            map.put("fail","未指定商品");
            return map;
        }
        ProductInfoView product = productService.getProductInfo(productId);
        System.out.println("product="+product);
        if(product == null){
            map.put("fail","找不到該項商品");
        }else if(!PRODUCT_STATUS_PUBLISHED.equals(product.getStatus())){
            map.put("fail","找不到該項商品");
        }else {
            map.put("success","");
        }
        return map;
    }
	
	@RequestMapping("/showCart")
	public String cart(Model model,
						@RequestParam(required = false) Integer memberId
	) {
		UsedCart getCart = cartService.getUncheckOutCart(memberId);
		model.addAttribute("cartDetailList",cartService.getCartDetailList(getCart.getId()));
		model.addAttribute("cartInfoList", cartService.getCartDetailInfo(getCart.getId()));
		model.addAttribute("categoryList", categoryService.getCategoryList());
		return "/used/Cart";
	}
	
	@RequestMapping("/showCheckOut")
	public String showcheckOut(Model model, 
			@RequestParam(required = false) Integer memberId) {
		UsedCart getCart = cartService.getUncheckOutCart(memberId);
		model.addAttribute("cartDetailList", cartService.getCartDetailList(getCart.getId()));
		model.addAttribute("categoryList", categoryService.getCategoryList());
		model.addAttribute("cartInfoList", cartService.getCartDetailInfo(getCart.getId()));
		model.addAttribute("totalPrice", cartService.getCartTotal(getCart.getId()));
		model.addAttribute("cartId", getCart.getId());
		return "/used/CheckOut";
	}



	@DeleteMapping
	@ResponseBody
	public UsedCart deleteProductFromCart(
			@RequestParam Integer memberId, 
			@RequestParam Integer productId) {
		UsedCart uncheckOutCart = cartService.getUncheckOutCart(memberId);
		cartService.deleteProductFromCart(uncheckOutCart.getMemberId(), uncheckOutCart.getId(), productId);
		return uncheckOutCart;
	}

	@PutMapping
	public UsedCart checkOutAndUpdateStatus(
			@RequestParam Integer memberId,
			@RequestParam Integer cartId,
			@RequestParam Integer productId) {
		UsedCart uncheckOutCart = cartService.getUncheckOutCart(memberId);
		cartService.getCartDetailList(uncheckOutCart.getId());
		cartService.updateCartStatus(uncheckOutCart.getId());
		return uncheckOutCart;
	}

}
