package com.java18.nikolaos.ShoppingCart.controller;
//OrderConfirm.jsp 呼叫本程式。

import java.util.Date;
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
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java18.nikolaos.ShoppingCart.model.Order2Bean;
import com.java18.nikolaos.ShoppingCart.model.OrderItem2Bean;
import com.java18.nikolaos.ShoppingCart.model.ShoppingCart;
import com.java18.nikolaos.ShoppingCart.model.service.Order2Service;
import com.java18.nikolaos.register.model.MemberBean;



@Controller
@RequestMapping("/ShoppingCart")
@SessionAttributes({"ShoppingCart","loginMember","OrderErrorMessage"})
public class ProcessOrderController {

	@Autowired
	Order2Service order2Service; //石頭訂單Service
	
	
	
	@PostMapping("/ProcessOrder")
	protected String processOrder(
			Model model, 
			@RequestParam("ShippingAddress") String shippingAddress,//新增訂單
			@RequestParam("BNO") String bno,//新增訂單
			@RequestParam("finalDecision") String finalDecision,//新增訂單
			@RequestParam("InvoiceTitle") String invoiceTitle, //新增訂單
			WebRequest webRequest, SessionStatus status, RedirectAttributes ra			
			) {
				MemberBean memberBean = (MemberBean) model.getAttribute("loginMember");
				if (memberBean == null) {
					return "redirect:/login/login";
				}
				ShoppingCart sc = (ShoppingCart) model.getAttribute("ShoppingCart");
				if (sc == null) {
					// 處理訂單時如果找不到購物車(通常是Session逾時)，沒有必要往下執行
					// 導向首頁
					return "redirect:/login"; 
				}
				// 如果使用者取消訂單
				if (finalDecision.equalsIgnoreCase("CANCEL")) {
//					log.info("客戶最終決定取消訂單");
					return "forward:/ShoppingCart/abort"; //listColth/abort
				}
				// 如果使用者取消訂單
				if (finalDecision.equalsIgnoreCase("CANCEL")) {
//					log.info("客戶最終決定取消訂單");
					return "forward:/ShoppingCart/abort";//listColth/abort
				}
				Integer memberId = memberBean.getId();   						// 取出會員代號
				double totalAmount = Math.round(sc.getSubtotal() * 1.05);  	// 計算訂單總金額 
				Date today = new Date();   									// 新增訂單的時間
				// 新建訂單物件。OrderBean:封裝一筆訂單資料的容器，包含訂單主檔與訂單明細檔的資料。目前只存放訂單主檔的資料。
//				Order2Bean ob = new Order2Bean(null, memberId, totalAmount, shippingAddress, 
//						bNO, invoiceTitle, today, null, null);
				Order2Bean ob = new Order2Bean(null, bno, invoiceTitle,null, memberId,today,shippingAddress,null, totalAmount, null);
				
				
				// 取出存放在購物車內的商品，放入Map型態的變數cart，準備將其內的商品一個一個轉換為OrderItemBean，
				
				Map<Integer, OrderItem2Bean> content = sc.getContent();
				
				Set<OrderItem2Bean> items = new LinkedHashSet<>();
				Set<Integer> set = content.keySet();
				for(Integer i : set) {
					OrderItem2Bean oib = content.get(i);
					oib.setOrder2Bean(ob);
					items.add(oib);
				}
				// 執行到此，購物車內所有購買的商品已經全部轉換為為OrderItemBean物件，並放在Items內
				ob.setItems(items);
				try {
					order2Service.persistOrder(ob);
//					status.setComplete();
//					webRequest.removeAttribute("ShoppingCart", WebRequest.SCOPE_SESSION);
//					log.info("訂單已經成功寫入表格");
					model.addAttribute("MemberName_ThanksForOrdering", memberBean.getName()) ;
					return "forward:" + "/ShoppingCart/removeShoppingCart";
				} catch(RuntimeException ex){
					String message = ex.getMessage();
					String shortMsg = "" ;   
					System.out.println("message=" + message);
					shortMsg =  message.substring(message.indexOf(":") + 1);
//					log.info("處理訂單時發生異常: " + shortMsg);
					model.addAttribute("OrderErrorMessage", "處理訂單時發生異常: " + shortMsg  + "，請調正訂單內容" );
					return "redirect:/ShoppingCart/test_ShowCartContent";
				}
			}

	
										
		
	}
	
	
