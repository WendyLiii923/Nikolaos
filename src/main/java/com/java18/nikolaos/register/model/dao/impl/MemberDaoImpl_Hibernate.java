package com.java18.nikolaos.register.model.dao.impl;

import java.sql.Connection;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java18.nikolaos.register.model.MemberBean;
import com.java18.nikolaos.register.model.dao.MemberDao;
@Repository
public class MemberDaoImpl_Hibernate implements MemberDao {
	
	
	SessionFactory factory;
	@Autowired
	public MemberDaoImpl_Hibernate(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	public void save(MemberBean mb) {
		Session session = factory.getCurrentSession();
		session.save(mb);
	}
	
	@Override
	public boolean existsByEmail(String email) {
		boolean exist = false;
		String hql = "FROM MemberBean WHERE email = :memail ";
		Session session = factory.getCurrentSession();
		try {
			MemberBean bean = (MemberBean) session.createQuery(hql)
												  .setParameter("memail", email)
												  .getSingleResult();
			if (bean != null) {
				exist = true;
			}
		} catch(NoResultException e) {
			exist = false;
		} catch(NonUniqueResultException e) {
			exist = true;
		} 
		return exist;
	}
	
	@Override
	public MemberBean findByEmail(String email) {
		MemberBean mb = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean m WHERE m.email = :memail";
		try {
			mb = (MemberBean) session.createQuery(hql)
									 .setParameter("memail", email)
									 .getSingleResult();
		} catch(NoResultException e) {
			mb = null;
		} 
		return mb;
	}
	@Override
	public MemberBean findByEmailAndPassword(String email, String password) {
		MemberBean mb = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean m WHERE m.email = :memail and m.password = :pswd";
		try {
			mb = (MemberBean) session.createQuery(hql)
							.setParameter("memail", email)
							.setParameter("pswd", password)
							.getSingleResult();
		} catch(NoResultException e) {
			mb = null;
		} 
		return mb;
	}
	
	@Override
	public void updateMember(MemberBean bean) {
		Session session = factory.getCurrentSession();
		MemberBean b0 = session.get(MemberBean.class, bean.getId());
		final String password = bean.getPassword();
		if (password != null && !password.isEmpty()) {
			b0.setPassword(password);
		}
		b0.setName(bean.getName());
		b0.setEmail(bean.getEmail());
		b0.setPhone(bean.getPhone());
		b0.setAddress(bean.getAddress());
		session.saveOrUpdate(b0);
	}
	
	@Override
	public void setConnection(Connection conn) {
		throw new RuntimeException("不支援setConnection(Connection con)方法...");
	}
	
	@Override
	 public MemberBean findById(Integer id) {
		MemberBean bean = null;
	  Session session = factory.getCurrentSession();
	  bean = session.get(MemberBean.class, id);
	  return bean;
	 }
}
