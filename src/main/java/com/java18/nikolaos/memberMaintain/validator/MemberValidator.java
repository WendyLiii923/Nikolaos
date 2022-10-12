package com.java18.nikolaos.memberMaintain.validator;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;
import com.java18.nikolaos.register.model.MemberBean;
public class MemberValidator implements Validator {
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
//		MemberBean mb = (MemberBean) target;
//		log.info("BookValidator：檢查物件: " + bean);
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "帳號欄不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "", "姓名欄不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "phone", "", "電話欄不能空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "address", "", "地址欄不能空白");
	}
}
