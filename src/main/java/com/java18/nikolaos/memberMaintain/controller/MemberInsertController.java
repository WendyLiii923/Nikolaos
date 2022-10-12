package com.java18.nikolaos.memberMaintain.controller;

import java.sql.Blob;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;
//import javax.validation.Valid;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import _00_init.util.SystemUtils2018;
//import com.java18.nikolaos.listProducts.model.ProductBean;
//import com.java18.nikolaos.listProducts.model.ColorBean;
//import com.java18.nikolaos.listProducts.model.SizeBean;
//import com.java18.nikolaos.listProducts.model.service.ProductService;
//import com.java18.nikolaos.listProducts.model.service.ColorService;
//import com.java18.nikolaos.listProducts.model.service.SizeService;
//import com.java18.nikolaos.productMaintain.validator.ProductValidator;
import com.java18.nikolaos.register.model.MemberBean;
import com.java18.nikolaos.register.model.service.MemberService;
import com.java18.nikolaos.memberMaintain.validator.MemberValidator;
@Controller
@RequestMapping("/memberMaintain")
                
@SessionAttributes({ "loginMember" })
public class MemberInsertController {

  
	MemberService memberService;
	
	@Autowired
	public MemberInsertController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("MemberUpdate")
	public String showUpdateForm(Model model) {
		MemberBean mb = (MemberBean) model.getAttribute("loginMember");
		if (mb == null) {
			return "login/loginForm";
		}
		return "memberMaintain/MemberUpdate";
	}
	
	
	@PostMapping("MemberUpdate")
	public String updateForm(@ModelAttribute MemberBean bean,
			@SessionAttribute("loginMember") MemberBean loginMember,
			Model model, BindingResult result, 
			RedirectAttributes redirectAttributes
			) {
		MemberValidator  validator = new MemberValidator(false);
		validator.validate(bean, result);
		if (result.hasErrors()) {
				System.out.println("======================");
				List<ObjectError> list = result.getAllErrors();
				for(ObjectError error : list) {
					System.out.println("有錯誤：" + error);
				}
				System.out.println("======================");
			return "memberMaintain/MemberUpdate";
		}
		
		bean.setId(loginMember.getId());
		memberService.updateMember(bean);
		redirectAttributes.addFlashAttribute("SUCCESS", "修改成功!!!");
		return "redirect:/memberMaintain/MemberUpdate";
	}
	
}
