package com.java18.nikolaos.general.model.dao;

import com.java18.nikolaos.register.model.MemberBean;

public interface MembersDao {

	public MemberBean getMember(String email,String password);
	
}
