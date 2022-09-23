package com.java18.nikolaos.used.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java18.nikolaos.used.model.OrderDetailView;

@Repository
public class OrderInfoViewDaoImpl implements OrderInfoViewDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	private String hql = "";
	
	private Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	@Override
	public OrderDetailView getOrderInfoById(Integer orderId) {
//		Query<OrderDetailView> check = getSession().createQuery(hql, OrderDetailView.class);
//		check.setParameter("orderId", orderId);
//		List<OrderDetailView> list = check.list();
		return null;
	}

}
