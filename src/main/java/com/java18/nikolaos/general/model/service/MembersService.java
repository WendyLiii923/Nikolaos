package com.java18.nikolaos.general.model.service;

import com.java18.nikolaos.register.model.MemberBean;

public interface MembersService {

	public MemberBean login(String email,String password);
	
}
