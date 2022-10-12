package com.java18.nikolaos.ShoppingCart.model.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java18.nikolaos.ShoppingCart.model.Order2Bean;
import com.java18.nikolaos.ShoppingCart.model.dao.Order2Dao;

@Repository
public class Order2DaoImpl_Hibernate implements Order2Dao {

	SessionFactory factory;
	
	@Autowired
	public Order2DaoImpl_Hibernate(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public void save(Order2Bean order2Bean) {
		Session session = factory.getCurrentSession();
		session.save(order2Bean);

	}

	@Override
	public Order2Bean findById(int orderNo) {
		Order2Bean ob = null;
		Session session = factory.getCurrentSession();
		ob = session.get(Order2Bean.class, orderNo);
		return ob;
	}

	@Override
	public List<Order2Bean> findByMemberId(String memberId) {
		List<Order2Bean> list = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM Order2Bean ob WHERE ob.memberId =:mid";
		list = session.createQuery(hql, Order2Bean.class).setParameter("mid", memberId).getResultList();
		return list;
	}

	@Override
	public void setConnection(Connection con) {
		throw new RuntimeException("OrderDaoImpl_Hibernate類別不用實作此方法");

	}

}
