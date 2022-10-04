package com.java18.nikolaos.orders.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java18.nikolaos.orders.model.Orders;
import com.java18.nikolaos.orders.model.service.OrdersService;

@Controller
@RequestMapping("/orders")
public class OrdersController {

	@Autowired
	OrdersService os;
//	@Autowired
//	MemberService ms;

	@GetMapping("/ordersIndex")
	public  String homepage() {
		return "/orders/ordersIndex";
	}

//	@PostMapping(value = "/order", produces = "application/json; charset=UTF-8")
//	public @ResponseBody Orders findById(@RequestBody Map<Object,Object> id) {
//		return os.findById(Integer.valueOf( (String) id.get("id")));
//	}

//	@PostMapping(value = "/addOrder", produces = "application/x-www-form-urlencoded")
//	public @ResponseBody String addOrders(
//			@RequestBody Map<Object,Object> shipping_address,
//			@RequestBody Map<Object,Object> recipient, 
//			@RequestBody Map<Object,Object> total_amount,
//			@RequestBody Map<Object,Object> recip_phone) {
//		String shipping_address1= (String) shipping_address.get("shipping_address");
//		String recipient1 = (String) recipient.get("recipient");
//		Double total_amount1 = Double.valueOf((String) total_amount.get("total_amount"));
//		String recip_phone1 = (String) recip_phone.get("recip_phone");
//		Orders orders = new Orders(shipping_address1, recipient1, total_amount1, recip_phone1);
//		os.saveOrder(orders);
//		return "新增成功";
//	}
	@PostMapping(value = "/addOrder")
	@ResponseBody
	public String addOrders(
			@RequestParam("shipping_address") String shipping_address,
			@RequestParam("recipient") String recipient, 
			@RequestParam("total_amount") String total_amount,
			@RequestParam("recip_phone") String recip_phone
//			@RequestParam("member_id") String member_id
			) {
//		Orders orders = new Orders(null,null,shipping_address,null, recipient, Double.valueOf(total_amount),null,null, recip_phone);
		Orders orders = new Orders(shipping_address, recipient, Double.valueOf(total_amount), recip_phone);
		os.saveOrder(orders);
		return "/";
	}
	
	@GetMapping(value = "/ordersAlter")
	public String ordersAlter(Model model,@RequestParam("id") Integer id) {
		model.addAttribute("order",os.findById(id));
		return"/orders/testorder";
	}

	@PostMapping(value = "/updataOrders", produces = "text/plain;charset=UTF-8")
	public @ResponseBody void updataOrders(@RequestParam("id") String id, 
			@RequestParam("shipping_address") String shipping_address,
			@RequestParam("recipient") String recipient, 
			@RequestParam("recip_phone") String recip_phone) {
		Orders orders = os.findById(Integer.valueOf(id));
		orders.setShipping_address(shipping_address);
		orders.setRecipient(recipient);
		orders.setRecip_phone(recip_phone);
		os.updateOrder(orders);
	}

	@GetMapping(value = "/ordersAll", produces = "application/json; charset=UTF-8")
	public @ResponseBody List<Orders> ordersAll() {
		return os.findAllOrders();
	}

	@GetMapping(value = "/order", produces = "application/json; charset=UTF-8")
	public @ResponseBody Orders findById(@RequestParam(name = "id") Integer id) {
		return os.findById(id);
	}

	// http://localhost:8080/nikolaos/{abc} PathVAr String abc
//    http://localhost:8080/nikolaos?abc=1  REQuestparam Strin abc 
//	@GetMapping("/order/{id}")
//	public @ResponseBody Orders Orders(@PathVariable Integer id) {
//		return  os.findById(id);
//	}
}
