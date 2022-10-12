package com.java18.nikolaos.memberMaintain.validator;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.java18.nikolaos.register.model.MemberBean;

public class MemberValidator implements Validator {

//	private static Logger log = LoggerFactory.getLogger(MemberValidator.class);
	
	boolean insertMode = true;
	
	public MemberValidator() {
	}

	public MemberValidator(boolean insertMode) {
		this.insertMode = insertMode;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return MemberBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		MemberBean mb = (MemberBean) target;
//		log.info("BookValidator：檢查物件: " + bean);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "帳號欄不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "姓名欄不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "", "電話欄不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "", "地址欄不能空白");
		
//		Double price = Double.parseDouble(bean.getListPrice());
		
//		if (bean.getCategory().equals("0")) {
//			errors.rejectValue("category","", "必須挑選分類欄");
//		}
//		if (insertMode) {
//			if (bean.getProductImage().isEmpty()) {
//				errors.rejectValue("productImage","", "必須挑選圖片");
//			}
//		}
//		if (bean.getCompanyBean().getId() == -1) {
//			errors.rejectValue("companyBean","", "必須挑選出版社");
//		}
		
//		if ( mb.getPassword().equals(mb.getPassword2())) {
//			errors.rejectValue("password","", "新密碼不能與舊密碼相同");
//		}
//		
//		if (! mb.getPassword2().equals(mb.getPassword1())) {
//			errors.rejectValue("password","", "密碼欄與確認密碼不一致");
//		}
	}
}
