package com.java18.nikolaos.used.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

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

	@RequestMapping("/showOrder")
	public String order(Model model,
					   @RequestParam(required = false) Integer categoryId,
					   @RequestParam(required = false) Integer orderId
						) {
		model.addAttribute("orderList", orderService.getOrderList(orderId));
		model.addAttribute("orderDetailList", orderService.getOrderDetailList(orderId));
		model.addAttribute("category", categoryService.getCategoryById(categoryId));
		model.addAttribute("categoryList", categoryService.getCategoryList());
		return "/used/Order";
	}
	
	@PostMapping
	@ResponseBody
	public UsedOrder addOrderDetail(
			@RequestParam Integer cartId,
			@RequestParam Integer memberId, 
			@RequestParam Integer totalPrice,
			@RequestParam Integer shippingFee) {
		UsedOrder order = orderService.createOrder(memberId, totalPrice, shippingFee);
		orderService.addOrderDetail(order.getId(), cartId);
		return order;
	}

}
