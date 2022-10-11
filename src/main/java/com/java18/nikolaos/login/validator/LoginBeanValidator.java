package com.java18.nikolaos.login.validator;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.java18.nikolaos.login.model.LoginBean;

public class LoginBeanValidator implements Validator {

//	private static Logger log = LoggerFactory.getLogger(LoginBeanValidator.class);
	
	@Override
	public boolean supports(Class<?> clazz) {
		return LoginBean.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
//		log.info("執行LoginBeanValidator#validate()");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "", "帳號欄不能為空白");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "", "密碼欄不能為空白");
	}

}
