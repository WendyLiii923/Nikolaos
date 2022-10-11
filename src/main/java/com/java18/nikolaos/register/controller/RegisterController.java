package com.java18.nikolaos.register.controller;

import java.sql.Blob;
import java.sql.Timestamp;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.sql.rowset.serial.SerialBlob;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java18.nikolaos.register.model.MemberBean;
import com.java18.nikolaos.register.model.service.MemberService;
import com.java18.nikolaos.register.util.GlobalService;
import com.java18.nikolaos.register.validator.MemberBeanValidator;

@Controller
@RequestMapping("/register")
public class RegisterController {
	
//	private static Logger log = LoggerFactory.getLogger(RegisterController.class);
	
//	String rootDirectory = "d:\\images";
	String inputDataForm = "register/registerForm"; 
	
	MemberService memberService;
	
	ServletContext servletContext;
	
	@Autowired
	public RegisterController(MemberService memberService, ServletContext servletContext) {
		this.memberService = memberService;
		this.servletContext = servletContext;
	}

	@GetMapping("/register")
	public String sendingEmptyForm(Model model) {
		MemberBean memberBean = new MemberBean();
//		memberBean.setName("王麗莎" );
//		memberBean.setPassword("Do!ng456");
//		memberBean.setPassword1("Do!ng456");
//		memberBean.setMemberId("a1011");
//		memberBean.setAddress("新竹市大同路100號");
//		memberBean.setTel("0919-123456");
//		memberBean.setEmail("scwang39165@outlook.com");
		model.addAttribute("memberBean", memberBean);
		return inputDataForm;
	}
	
	@PostMapping("/register")
	public String processFormData(
			@ModelAttribute("memberBean") MemberBean bean,
			BindingResult result, Model model,
			RedirectAttributes ra
		) {
		MemberBeanValidator validator = new MemberBeanValidator();
		validator.validate(bean, result);
		if (result.hasErrors()) {
//          下列敘述可以理解Spring MVC如何處理錯誤			
//			List<ObjectError> list = result.getAllErrors();
//			for (ObjectError error : list) {
//				System.out.println("有錯誤：" + error);
//			}
			return inputDataForm;
		}
		
//		MultipartFile picture = bean.getMemberMultipartFile();
//		String originalFilename = picture.getOriginalFilename();
//		
//		if (originalFilename.length() > 0 && originalFilename.lastIndexOf(".") > -1) {
//			bean.setFileName(originalFilename);
//		}
//		// 建立Blob物件，交由 Hibernate 寫入資料庫
//		if (picture != null && !picture.isEmpty()) {
//			try {
//				byte[] b = picture.getBytes();
//				Blob blob = new SerialBlob(b);
//				bean.setMemberImage(blob);
//			} catch (Exception e) {
//				e.printStackTrace();
//				throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
//			}
//		}
//        String mimeType = servletContext.getMimeType(originalFilename); 
//        bean.setMimeType(mimeType);
//		
//		Timestamp registerTime = new Timestamp(System.currentTimeMillis());
//		bean.setRegisterTime(registerTime);
//		
		// 檢查 memberId是否重複
		if (memberService.existsByEmail(bean.getEmail())) {
			result.rejectValue("email", "", "帳號已存在，請重新輸入");
			return inputDataForm;
		}
		
		bean.setPassword(GlobalService.getMD5Endocing(
				GlobalService.encryptString(bean.getPassword())));
		try {
			memberService.save(bean);
//			log.info("寫入MemberBean物件：" + bean);
			ra.addFlashAttribute("SUCCESS", "會員: " + bean.getName() +  "資料新增成功");
		} 
		catch (Exception ex) {
			System.out.println(ex.getClass().getName() + ", ex.getMessage()=" + ex.getMessage());
			result.rejectValue("email", "", "發生異常，請通知系統人員..." + ex.getMessage());
			return inputDataForm;
		}
		// 將上傳的檔案移到指定的資料夾, 目前註解此功能
//		String ext = "";
//		if (originalFilename.lastIndexOf(".") > -1) {
//			ext = originalFilename.substring(originalFilename.lastIndexOf("."));
//		}
//		try {
//			File imageFolder = new File(rootDirectory, "images");
//			if (!imageFolder.exists())
//				imageFolder.mkdirs();
//			File file = new File(imageFolder, "MemberImage_" + bean.getMemberId() + ext);
//			picture.transferTo(file);
//		} catch (Exception e) {
//			e.printStackTrace();
//			throw new RuntimeException("檔案上傳發生異常: " + e.getMessage());
//		}
		return "redirect:/";
		
	}
	
	@ModelAttribute
	public MemberBean prepareMemberBean(HttpServletRequest req) {
		MemberBean memberBean = new MemberBean();
//		memberBean.setTotalAmt(0.0);
//		memberBean.setUnpaid_amount(0.0);
//		memberBean.setUserType("M");
		return memberBean;
	}
	
}
