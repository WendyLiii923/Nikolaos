package com.java18.nikolaos.used.controller;

import com.java18.nikolaos.used.model.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java18.nikolaos.used.model.UsedCart;
import com.java18.nikolaos.used.model.service.CartService;

@Controller
@RequestMapping("/CartService")
public class CartController {
	
	@Autowired
	CartService cartService;
	@Autowired
	CategoryService categoryService;

	@RequestMapping("/addCart")
	public String add(Model model,
						@RequestParam(required = false) Integer memberId,
						@RequestParam(required = false) Integer productId,
						@RequestParam(required = false) Integer productQty
	) {
		UsedCart getCart = cartService.getUncheckOutCart(memberId);
		model.addAttribute("cartDetail",cartService.createCartDetail(getCart.getId(), productId, productQty));
		model.addAttribute("cartDetailList",cartService.getCartDetailList(getCart.getId()));
		model.addAttribute("categoryList", categoryService.getCategoryList());
		return "/used/Cart";
	}
	
	@RequestMapping("/showCart")
	public String cart(Model model,
						@RequestParam(required = false) Integer memberId
	) {
		UsedCart getCart = cartService.getUncheckOutCart(memberId);
		model.addAttribute("cartDetailList",cartService.getCartDetailList(getCart.getId()));
		model.addAttribute("categoryList", categoryService.getCategoryList());
		return "/used/Cart";
	}
	
	@RequestMapping("/showCheckOut")
	public String checkOut(Model model,
						@RequestParam(required = false) Integer memberId
	) {
		UsedCart getCart = cartService.getUncheckOutCart(memberId);
		model.addAttribute("cartDetailList",cartService.getCartDetailList(getCart.getId()));
		model.addAttribute("categoryList", categoryService.getCategoryList());
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
