package com.java18.nikolaos.general.model.dao;

import com.java18.nikolaos.used.model.Members;

public interface MembersDao {

	public Members getMember(String email,String password);
	
}
