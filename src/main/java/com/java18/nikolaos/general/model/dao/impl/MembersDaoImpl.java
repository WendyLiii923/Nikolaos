package com.java18.nikolaos.general.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java18.nikolaos.used.model.Members;

@Repository
public class MembersDaoImpl implements MembersDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private final String selectMemberByMemberIdAndPassword = "From com.java18.nikolaos.used.model.Members WHERE memberId=:memberId AND password=:password";
	
	private Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	@Override
	public Members getMember(String memberId, String password) {
		Members result = null;
		
		Query<Members> check = getSession().createQuery(selectMemberByMemberIdAndPassword, Members.class);
		check.setParameter("memberId", memberId);
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
