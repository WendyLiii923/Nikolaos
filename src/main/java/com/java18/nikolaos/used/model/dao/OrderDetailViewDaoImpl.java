package com.java18.nikolaos.used.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java18.nikolaos.used.model.OrderDetailView;

@Repository
public class OrderDetailViewDaoImpl implements OrderDetailViewDao{
	
	@Autowired
	SessionFactory sessionFactory;
	
	private String selectOrderDetailByOrderId = "FROM com.java18.nikolaos.used.model.OrderDetailView WHERE orderId=:orderId";
	
	private Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	@Override
	public List<OrderDetailView> getOrderDetailInfoById(Integer orderId) {
		Query<OrderDetailView> check = getSession().createQuery(selectOrderDetailByOrderId, OrderDetailView.class);
		check.setParameter("orderId", orderId);
		List<OrderDetailView> list = check.list();
		return list;
	}

}
