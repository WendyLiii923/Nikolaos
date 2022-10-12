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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.java18.nikolaos.orders.model.Orders;
import com.java18.nikolaos.orders.model.service.OrdersService;
import com.java18.nikolaos.register.model.service.MemberService;

@Controller
@RequestMapping("/orders")
@SessionAttributes({"loginMember"})
public class OrdersController {

	@Autowired
	OrdersService os;
	@Autowired
	MemberService ms;

	//引導到訂單管理系統頁面
	@GetMapping("/ordersIndex")
	public String homepage() {
		return "/orders/orderManagement";
	}
	//取消訂單 取消完導回訂單管理系統
	@GetMapping("/cancelOrder")
	public String cancelOrder(@RequestParam("id")Integer id ) {
		Orders order= os.findById(id);
		order.setCancel_tag(true);
		os.cancelOrder(order);	
		return "/orders/orderManagement";
		
	}

	//修改訂單 回傳到特定頁面
	@GetMapping(value = "/orderAlter")
	public String ordersAlter(
			Model model, 
			@RequestParam("id") Integer id) {
		
		model.addAttribute("order", os.findById(id));
		return "/orders/Order_Ente_To_Modify";
	}
	

	//修改訂單
	@PostMapping(value = "/updataOrders")
	@ResponseBody
	public void updataOrders(
			@RequestParam("id") String id, 
			@RequestParam("shipping_address") String shipping_address,
			@RequestParam("recipient") String recipient, 
			@RequestParam("recip_phone") String recip_phone) {
		Orders orders = os.findById(Integer.valueOf(id));
		orders.setShipping_address(shipping_address);
		orders.setRecipient(recipient);
		orders.setRecip_phone(recip_phone);
		os.updateOrder(orders);
	}

	//取得所有訂單
	@GetMapping(value = "/ordersAll", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public List<Orders> ordersAll() {
		List<Orders> oo=os.findAllOrders();
		return oo;
	}

	//搜尋訂單 依訂單編號
	@GetMapping(value = "/getorder", produces = "application/json; charset=UTF-8")
	@ResponseBody
	public Orders findById(@RequestParam(name = "id") Integer id) {
		return os.findById(id);
	}

}
