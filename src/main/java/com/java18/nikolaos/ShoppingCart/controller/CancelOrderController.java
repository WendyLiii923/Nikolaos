package com.java18.nikolaos.ShoppingCart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ShoppingCart")
@SessionAttributes({"ShoppingCart"})
public class CancelOrderController {

//	@GetMapping("/cancelOrder")
	@PostMapping("/ProcessOrder.do")
	protected String cancelOrder(Model model, 
			WebRequest webRequest, SessionStatus status, 
			RedirectAttributes ra) {
//		log.info("使用者取消訂單(OK)");
		status.setComplete();
		String cancelOrder = "您已經取消訂單，期待您再次光臨";
		ra.addFlashAttribute("cancelOrder", cancelOrder);
		return "redirect:/";
	}
}
