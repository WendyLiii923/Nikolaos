package com.java18.nikolaos.used.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java18.nikolaos.used.model.UsedCart;
import com.java18.nikolaos.used.model.UsedOrder;
import com.java18.nikolaos.used.model.service.CartService;
import com.java18.nikolaos.used.model.service.CategoryService;
import com.java18.nikolaos.used.model.service.OrderService;

@Controller
@RequestMapping("/OrderService")
public class OrderController {

	@Autowired
	OrderService orderService;
	@Autowired
	CartService cartService;
	@Autowired
	CategoryService categoryService;

	@PostMapping
	@RequestMapping("/showOrderList")
	public String order(Model model,
			@RequestParam(required = false) Integer memberId,
	   		@RequestParam(required = false) Integer orderId,
	   		@RequestParam(required = false) Integer totalPrice,
			@RequestParam(required = false) Integer shippingFee,
			@RequestParam(required = false) String email,
			@RequestParam(required = false) String address,
			@RequestParam(required = false) String phone
						) {
		
		UsedCart cart = cartService.getUncheckOutCart(memberId);
		UsedOrder order = orderService.createOrder(memberId, totalPrice, shippingFee, email, address, phone);
		orderService.addOrderDetail(order.getId(), cart.getId());
		model.addAttribute("orderList", orderService.getOrderList(memberId));
		model.addAttribute("order", orderService.getOrder(order.getId()));
		model.addAttribute("orderInfoList", orderService.getOrderDetailView(order.getId()));
		model.addAttribute("orderDetailList", orderService.getOrderDetailList(order.getId()));
		model.addAttribute("categoryList", categoryService.getCategoryList());
		return "/used/OrderDetail";
	}
	
	
	@PostMapping
	@ResponseBody
	public UsedOrder createOrder(
			@RequestParam Integer cartId,
			@RequestParam Integer memberId, 
			@RequestParam(required = false) Integer totalPrice,
			@RequestParam(required = false) Integer shippingFee,
			@RequestParam(required = false) String email,
			@RequestParam(required = false) String address,
			@RequestParam(required = false) String phone
			) {
		UsedOrder order = orderService.createOrder(memberId, totalPrice, shippingFee, email, address, phone);
		orderService.addOrderDetail(order.getId(), cartId);
		return order;
	}

}
