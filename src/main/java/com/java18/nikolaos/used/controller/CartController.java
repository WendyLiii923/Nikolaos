package com.java18.nikolaos.used.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
		cartService.getCartDetailList(uncheckOutCart.getId(), productId);
		cartService.updateCartStatus(uncheckOutCart.getId());
		return null;
	}

}
