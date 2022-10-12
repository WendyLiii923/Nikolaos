package com.java18.nikolaos.ShoppingCart.controller;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java18.nikolaos.ShoppingCart.model.ShoppingCart;




@Controller
@RequestMapping("/ShoppingCart")
@SessionAttributes({"ShoppingCart","loginMember"})//"LoginOK",
public class ShoppingCartController {
//	private static Logger log = LoggerFactory.getLogger(ShoppingCartController.class);
	
	private final static String SHOW_CART_CONTENT = "ShoppingCart/test_ShowCartContent";//修改 
//	@GetMapping("/ShowCartContent")
	protected String showCartContent(Model model, SessionStatus status) {
		MemberBean memberBean = (MemberBean) model.getAttribute("loginMember");
		if (memberBean == null) {
			status.setComplete();
			return "redirect:/login/login";
		}
		return  "ShoppingCart/test_ShowCartContent";//修改
	}
	
	@GetMapping("/checkout")
	protected String checkout(Model model, SessionStatus status) {
		MemberBean memberBean = (MemberBean) model.getAttribute("loginMember");
		if (memberBean == null) {
			status.setComplete();
			return "redirect:/login/login";//修改
		}
//		log.info("訂單確認");
		return  "ShoppingCart/test_OrderConfirm";//修改		
	}
	@PostMapping("/UpdateItem.do")
	protected String UpdateIte(
			@RequestParam("cmd")   String cmd,  
			@RequestParam(value = "id", required = false) Integer  id, //bookId 修改
			@RequestParam(value = "newQty", required = false) Integer  newQty, 
			Model model, 
			RedirectAttributes ra, 
			/*HttpSession session, */ SessionStatus status	
	) {

		ShoppingCart sc = (ShoppingCart) model.getAttribute("ShoppingCart");
		if (sc == null) {
			status.setComplete();
			return "redirect:/listClothes/BuyCloth.do";
			return "redirect:/login/login";
		}
		MemberBean memberBean = (MemberBean) model.getAttribute("loginMember");
		if (memberBean == null) {
			status.setComplete();
			return "redirect:/login/login";
		}
//				log.info("cmd=" + cmd);
		if (cmd.equalsIgnoreCase("DEL")) {
			sc.deleteCloth(id); // 刪除購物車內的某項商品 //id bookId
			return SHOW_CART_CONTENT;
		} else if (cmd.equalsIgnoreCase("MOD")) {
			sc.modifyQty(id, newQty); // 修改某項商品的數項
			return SHOW_CART_CONTENT;
		} else {
			return SHOW_CART_CONTENT;
		}
		
		
		
		
		
		
	}
	
}
