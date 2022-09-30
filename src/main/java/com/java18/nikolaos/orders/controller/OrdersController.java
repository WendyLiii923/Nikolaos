package com.java18.nikolaos.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java18.nikolaos.orders.model.Orders;
import com.java18.nikolaos.orders.model.service.OrdersService;

@Controller
public class OrdersController {
	@Autowired
	OrdersService os;

//	@GetMapping("/")
//	public  String homepage() {
//		return "index";
//	}

//	@PostMapping(value = "/order", produces = "application/json; charset=UTF-8")
//	public @ResponseBody Orders findById(@RequestBody Map<Object,Object> id) {
//		return os.findById(Integer.valueOf( (String) id.get("id")));
//	}
	@PostMapping(value = "/addOrder", produces = "application/json; charset=UTF-8")
	public @ResponseBody String findById(
			@RequestParam("shipping_address") String shipping_address,
			@RequestParam("recipient") String recipient, 
			@RequestParam("total_amount") Double total_amount,
			@RequestParam("recip_phone") String recip_phone) {
		Orders orders = new Orders(shipping_address, recip_phone, total_amount, recip_phone);

		return "新增成功";
	}

	@GetMapping(value = "/ordersAll", produces = "application/json; charset=UTF-8")
	public @ResponseBody List<Orders> ordersAll() {
		return os.findAllOrders();
	}

	@GetMapping(value = "/order", produces = "application/json; charset=UTF-8")
	public @ResponseBody Orders order(@RequestParam("id") Integer id) {
		return os.findById(id);
	}

	// http://localhost:8080/nikolaos/{abc} PathVAr String abc
//    http://localhost:8080/nikolaos?abc=1  REQuestparam Strin abc 
//	@GetMapping("/order/{id}")
//	public @ResponseBody Orders Orders(@PathVariable Integer id) {
//		return  os.findById(id);
//	}
}
