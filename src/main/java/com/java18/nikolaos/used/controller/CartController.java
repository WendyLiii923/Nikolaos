package com.java18.nikolaos.used.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.view.RedirectView;

import com.java18.nikolaos.used.model.UsedCart;
import com.java18.nikolaos.used.model.service.CartService;
import com.java18.nikolaos.used.model.service.CategoryService;

@Controller
@RequestMapping("/CartService")
public class CartController {
	
	@Autowired
	CartService cartService;
	@Autowired
	CategoryService categoryService;
	
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

	@RequestMapping("/addCart")
	public RedirectView add(Model model,
						@RequestParam(required = false) Integer memberId,
						@RequestParam(required = false) Integer productId,
						@RequestParam(required = false) Integer productQty
	) {
		UsedCart getCart = cartService.getUncheckOutCart(memberId);
		model.addAttribute("cartDetail",cartService.createCartDetail(getCart.getId(), productId, productQty));
		model.addAttribute("cartDetailList",cartService.getCartDetailList(getCart.getId()));
		model.addAttribute("cartInfoList", cartService.getCartDetailInfo(getCart.getId()));
		model.addAttribute("categoryList", categoryService.getCategoryList());
		String url = "/nikolaos/CartService/showCart?memberId="+ memberId;
		return new RedirectView(url);
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
		return "/used/CheckOut";
	}

	@PostMapping
	@ResponseBody
	public UsedCart addProductToCart(
			@RequestParam Integer memberId, 
			@RequestParam Integer productId,
			@RequestParam Integer productQty) {
		UsedCart uncheckOutCart = cartService.getUncheckOutCart(memberId);
		cartService.createCartDetail(uncheckOutCart.getId(), productId, productQty);
		return uncheckOutCart;
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
