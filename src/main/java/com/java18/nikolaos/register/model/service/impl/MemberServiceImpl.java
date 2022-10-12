package com.java18.nikolaos.register.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java18.nikolaos.register.model.MemberBean;
import com.java18.nikolaos.register.model.dao.MemberDao;
import com.java18.nikolaos.register.model.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {
	MemberDao memberDao;

	@Autowired
	public MemberServiceImpl(MemberDao memberDao) {
		this.memberDao = memberDao;
	}

	@Transactional
	@Override
	public void save(MemberBean mb) {
		memberDao.save(mb);
	}

	@Transactional
	@Override
	public boolean existsByEmail(String email) {
		boolean exist = false;
		exist = memberDao.existsByEmail(email);
		return exist;
	}

	@Transactional
	@Override
	public MemberBean findByEmail(String email) {
		MemberBean mb = null;
		mb = memberDao.findByEmail(email);
		return mb;
	}

	@Transactional
	@Override
	public MemberBean findByEmailAndPassword(String email, String password) {
		MemberBean mb = null;
		mb = memberDao.findByEmailAndPassword(email, password);
		return mb;
	}

	@Transactional
	@Override
	public void updateMember(MemberBean bean) {
		memberDao.updateMember(bean);
	}
	@Transactional
	@Override
	public MemberBean findById (Integer id) {
		return memberDao.findById(id);
	}
}
