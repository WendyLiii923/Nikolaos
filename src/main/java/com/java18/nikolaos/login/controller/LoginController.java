package com.java18.nikolaos.login.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.java18.nikolaos.register.util.GlobalService;
import com.java18.nikolaos.register.model.MemberBean;
import com.java18.nikolaos.register.model.service.MemberService;
import com.java18.nikolaos.login.model.LoginBean;
import com.java18.nikolaos.login.validator.LoginBeanValidator;

@Controller("loginController2")
@RequestMapping("/login")
@SessionAttributes({"loginMember", "111", "222"}) 
public class LoginController {
	
//	private static Logger log = LoggerFactory.getLogger(LoginController.class);
	
	String loginForm = "login\\loginForm";
	String loginOut  = "login\\logout";
	
	MemberService memberService;
	
	@Autowired
	public LoginController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/login")
	public String login00(HttpServletRequest request, Model model, 
		@CookieValue(value="user", required = false) String user,
		@CookieValue(value="password", required = false) String password, 
		@CookieValue(value="rm", required = false) Boolean rm 
			) {
		if (user == null)
			user = "";
		if (password == null) {
			password = "";
		} else {
			password = GlobalService.decryptString(GlobalService.KEY, password);
		}
		
		if (rm != null) {
			rm = Boolean.valueOf(rm);
		} else {
			rm = false;
		}
			
		LoginBean bean = new LoginBean(user, password, rm);
		model.addAttribute(bean);	
//		log.info("??????????????????, userId=" + user);
		return loginForm;
	}
	
	@PostMapping("/login")
	public String checkAccount(
			@ModelAttribute("loginBean") LoginBean bean,
			BindingResult result, Model model,
			HttpServletRequest request, HttpServletResponse response) {
		
		LoginBeanValidator validator = new LoginBeanValidator();
		validator.validate(bean, result);
		if (result.hasErrors()) {
			return loginForm;
		}
		String password =bean.getPassword();
		MemberBean mb = null;
		try {
			// ?????? loginService????????? checkIDPassword()?????????userid???password????????????
			mb = memberService.findByEmailAndPassword(bean.getEmail(),
					GlobalService.getMD5Endocing(GlobalService.encryptString(password)));
			
			if (mb != null) {
				// OK, ????????????, ???mb????????????Session???????????????????????????"LoginOK"
				model.addAttribute("loginMember", mb);
//				log.info("???????????????MemberBean=" + mb);
			} else {
				// NG, ????????????, userid?????????????????????????????????????????????????????? errorMsgMap ??????
				result.rejectValue("invalidCredentials", "", "?????????????????????????????????");
//				log.info("???????????????userid=" + bean.getUserId() + ", ??????=" + password);
				return loginForm;
			}
		} catch (RuntimeException ex) {
			result.rejectValue("invalidCredentials", "", ex.getMessage());
			ex.printStackTrace();
			return loginForm;
		}
		HttpSession session = request.getSession();
		processCookies(bean, request, response);
		String nextPath = (String)session.getAttribute("requestURI");
		if (nextPath == null) {
			nextPath = request.getContextPath();
		}
		return "redirect: " + nextPath;
	}

	
	private void processCookies(LoginBean bean, HttpServletRequest request, HttpServletResponse response) {
		Cookie cookieUser = null;
		Cookie cookiePassword = null;
		Cookie cookieRememberMe = null;
		String email = bean.getEmail();
		String password = bean.getPassword();
		
		// rm????????????????????????RememberMe??????????????????????????????RememberMe?????????rm????????????null
		if (bean.isRememberMe()) {
			cookieUser = new Cookie("user", email);
			cookieUser.setMaxAge(7 * 24 * 60 * 60);       // Cookie????????????: ??????
			cookieUser.setPath(request.getContextPath());

			String encodePassword = GlobalService.encryptString(password);
			cookiePassword = new Cookie("password", encodePassword);
			cookiePassword.setMaxAge(7 * 24 * 60 * 60);
			cookiePassword.setPath(request.getContextPath());

			cookieRememberMe = new Cookie("rm", "true");
			cookieRememberMe.setMaxAge(7 * 24 * 60 * 60);
			cookieRememberMe.setPath(request.getContextPath());
		} else { // ?????????????????? RememberMe ??????
			cookieUser = new Cookie("user", email);
			cookieUser.setMaxAge(0); // MaxAge==0 ??????????????????????????????Cookie
			cookieUser.setPath(request.getContextPath());

			String encodePassword = GlobalService.encryptString(password);
			cookiePassword = new Cookie("password", encodePassword);
			cookiePassword.setMaxAge(0);
			cookiePassword.setPath(request.getContextPath());

			cookieRememberMe = new Cookie("rm", "true");
			cookieRememberMe.setMaxAge(0);
			cookieRememberMe.setPath(request.getContextPath());
		}
		response.addCookie(cookieUser);
		response.addCookie(cookiePassword);
		response.addCookie(cookieRememberMe);
		
	}
}
