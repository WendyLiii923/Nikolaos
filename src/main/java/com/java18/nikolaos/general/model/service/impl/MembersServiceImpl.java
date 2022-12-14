package com.java18.nikolaos.general.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java18.nikolaos.general.model.dao.MembersDao;
import com.java18.nikolaos.general.model.service.MembersService;
import com.java18.nikolaos.register.model.MemberBean;

@Service
@Transactional
public class MembersServiceImpl implements MembersService {

	@Autowired
	private MembersDao membersDao;
	
	@Override
	public MemberBean login(String email, String password) {
		return membersDao.getMember(email, password);
	}

}
