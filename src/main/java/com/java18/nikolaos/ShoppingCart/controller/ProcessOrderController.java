package com.java18.nikolaos.ShoppingCart.controller;
//OrderConfirm.jsp 呼叫本程式。

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.java18.nikolaos.ShoppingCart.model.OrderItem2Bean;
import com.java18.nikolaos.ShoppingCart.model.ShoppingCart;
import com.java18.nikolaos.ShoppingCart.model.service.Order2Service;
import com.java18.nikolaos.orders.model.Orders;
import com.java18.nikolaos.register.model.MemberBean;



@Controller
@RequestMapping("/ShoppingCart")
@SessionAttributes({"ShoppingCart","loginMember","OrderErrorMessage"})
public class ProcessOrderController {

	@Autowired
	Order2Service order2Service;
	
	@PostMapping("/ProcessOrder")
	protected String processOrder(Model model, 
			@RequestParam("shipping_address") String shipping_address,
			@RequestParam("recip_phone") String recip_phone,
			@RequestParam("shipping_method") Integer shipping_method
			) {
				MemberBean memberBean = (MemberBean) model.getAttribute("loginMember");
				if (memberBean == null) {
					return "redirect:/login/login";
				}
				ShoppingCart sc = (ShoppingCart) model.getAttribute("ShoppingCart");
				if (sc == null) {
					return "redirect:/login/login"; 
				}
				double totalAmount = Math.round(sc.getSubtotal() * 1.05);  	// 計算訂單總金額 
				Orders ob = new Orders();
				ob.setShipping_address(shipping_address);
				ob.setMember(memberBean.getId());
				ob.setTotal_amount(totalAmount);
				ob.setRecip_phone(recip_phone);
				ob.setShipping_method(shipping_method);
				ob.setRecipient(memberBean.getName());
				Map<Integer, OrderItem2Bean> content = sc.getContent();
				Set<OrderItem2Bean> items = new LinkedHashSet<>();
				Set<Integer> set = content.keySet();
				for(Integer i : set) {
					OrderItem2Bean oib = content.get(i);
					oib.setOrders(ob);
					items.add(oib);
				}
				ob.setOrderItem2Bean(items);
				try {
					order2Service.persistOrder(ob);
					return "redirect:/";
				} catch(RuntimeException ex){
					String message = ex.getMessage();
					String shortMsg = "" ;   
					System.out.println("message=" + message);
					shortMsg =  message.substring(message.indexOf(":") + 1);
					model.addAttribute("OrderErrorMessage", "處理訂單時發生異常: " + shortMsg  + "，請調正訂單內容" );
					return "redirect:/ShoppingCart/test_ShowCartContent";
				}
			}

	
										
		
	}
	
	
