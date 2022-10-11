package com.java18.nikolaos.login.controller;

import javax.servlet.http.HttpSession;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java18.nikolaos.register.model.MemberBean;

@Controller
@RequestMapping("/login")   // 
@SessionAttributes({"LoginOK"}) 
public class LogoutController {
	
//	private static Logger log = LoggerFactory.getLogger(LogoutController.class);
	
	@GetMapping("/showSessionData")
	public String retrieveSessionObject(Model model) {
		MemberBean memberBean = (MemberBean)model.getAttribute("LoginOK");
		model.addAttribute("memberName", memberBean.getName());
//		model.addAttribute("memberId", memberBean.getMemberId());
		model.addAttribute("memberEmail", memberBean.getEmail());
		return "showSessionData";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session,  Model model, SessionStatus status,
			RedirectAttributes redirectAtt
			) {
		String name = "";
		MemberBean memberBean = (MemberBean) model.getAttribute("LoginOK");
		if (memberBean != null) {
			name = memberBean.getName();
		} else {
			name = "訪客";
		}
//		log.info(name + "已登出");
//		String farewellMessage = name + "您已登出，期待您再次蒞臨本網站";
		redirectAtt.addFlashAttribute("logoutMessage");
		// 登出時執行下列兩敘述
		status.setComplete();		// 移除@SessionAttributes({"LoginOK"}) 標示的屬性物件
		session.invalidate();		// 此敘述不能省略		
		return "redirect:/";		// 跳轉回http://localhost:8080/Context_Path/
		
//		return "redirect: /";		// 跳轉回http://localhost:8080/
	}
}
