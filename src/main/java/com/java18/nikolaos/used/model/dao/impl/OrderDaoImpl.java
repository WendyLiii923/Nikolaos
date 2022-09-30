package com.java18.nikolaos.used.model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java18.nikolaos.used.model.UsedOrder;
import com.java18.nikolaos.used.model.dao.OrderDao;

@Repository
public class OrderDaoImpl implements OrderDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private final String selectOrderByMemberId = "FROM com.java18.nikolaos.used.model.UsedOrder WHERE memberId=:memberId";
	private String selectOrderByOrderId = "FROM com.java18.nikolaos.used.model.UsedOrder WHERE id=:orderId";
	
	public OrderDaoImpl() {
		
	}
	
	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	@Override
	public UsedOrder createOrder(Integer memberId, Integer totalPrice, Integer shippingFee, String email, 
								String address, String phone) {
		UsedOrder usedOrder = new UsedOrder();
		try {
			usedOrder.setMemberId(memberId);
			usedOrder.setTotalPrice(totalPrice);
			usedOrder.setShippingFee(60);
			usedOrder.setEmail(email);
			usedOrder.setAddress(address);
			usedOrder.setPhone(phone);
			getSession().save(usedOrder);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usedOrder;
	}

	@Override
	public List<UsedOrder> getOrderList(Integer memberId) {
		Query<UsedOrder> check = getSession().createQuery(selectOrderByMemberId, UsedOrder.class);
		check.setParameter("memberId", memberId);
		List<UsedOrder> list = check.list();
		return list;
	}

	@Override
	public UsedOrder getOrderInfoById(Integer orderId) {
		Query<UsedOrder> query = getSession().createQuery(selectOrderByOrderId, UsedOrder.class);
		query.setParameter("orderId", orderId);
		try {
			System.out.println("getOrderInfoById的orderId: " + orderId);
			return query.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	

}
