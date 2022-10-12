package com.java18.nikolaos.general.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java18.nikolaos.general.model.dao.MembersDao;
import com.java18.nikolaos.register.model.MemberBean;

@Repository
public class MembersDaoImpl implements MembersDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private final String selectMemberByMemberIdAndPassword = "From com.java18.nikolaos.used.model.Members WHERE email=:email AND password=:password";
	
	private Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	@Override
	public MemberBean getMember(String email, String password) {
		MemberBean result = null;
		
		Query<MemberBean> check = getSession().createQuery(selectMemberByMemberIdAndPassword, MemberBean.class);
		check.setParameter("email", email);
		check.setParameter("password", password);
		
		try {
			result = check.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Member not exist !");
		}
		
		return result;
	}

}
