package com.java18.nikolaos.ShoppingCart.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/ShoppingCart")
@SessionAttributes({ "ShoppingCart", "MemberName_ThanksForOrdering" })
public class RemoveShoppingCartController {
	@RequestMapping("/removeShoppingCart")
	public String removeCart(Model model, WebRequest webRequest, SessionStatus status, RedirectAttributes ra) {
		status.setComplete();
		webRequest.removeAttribute("ShoppingCart", WebRequest.SCOPE_SESSION);
		return "redirect:" + "/ShoppingCart/ThanksForOrdering";
	}
	@RequestMapping("/ThanksForOrdering")
	public String thanksForOrdering(Model model, WebRequest webRequest, SessionStatus status, RedirectAttributes ra) {
		ra.addFlashAttribute("MemberName_ThanksForOrdering", model.getAttribute("MemberName_ThanksForOrdering"));
		return "ThanksForOrdering";
	}

}
