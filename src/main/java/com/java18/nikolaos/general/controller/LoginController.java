package com.java18.nikolaos.general.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.java18.nikolaos.general.model.service.MembersService;
import com.java18.nikolaos.used.model.Members;

@Controller
@RequestMapping("/Auth")
@SessionAttributes(names= {"loginMember"})
public class LoginController {

	@Autowired
	private MembersService membersService;
	
	@PostMapping("/Login")
	public String login(@RequestParam String email,
						@RequestParam String password,
						Model model) {
		
		Members member = membersService.login(email, password);
		
		model.addAttribute("loginMember", member);
		
		return "/general/index";
	}
	
	@GetMapping("/Logout")
	public String logout(SessionStatus sessionStatus) {
		sessionStatus.setComplete();
		
		return "/general/index";
	}
}
