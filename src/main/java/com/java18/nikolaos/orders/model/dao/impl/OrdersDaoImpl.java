package com.java18.nikolaos.orders.model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java18.nikolaos.orders.model.Orders;
import com.java18.nikolaos.orders.model.dao.OrdersDao;

@Repository
public class OrdersDaoImpl implements OrdersDao {

	SessionFactory factory;

	@Autowired
	public OrdersDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public void saveOrder(Orders orders) {
		Session session = factory.getCurrentSession();
		session.save(orders);
	}

	@Override
	public Orders findById(Integer id) {
		Session session = factory.getCurrentSession();
		return session.get(Orders.class, id);
	}

	@Override
	public void updateOrder(Orders orders) {
		Session session = factory.getCurrentSession();
		Orders oo=session.get(Orders.class, orders.getId());
		oo.setShipping_address(orders.getShipping_address());
		oo.setRecip_phone(orders.getRecip_phone());
		oo.setRecipient(orders.getRecipient());
		session.evict(oo);
		session.saveOrUpdate(orders);
	}

	@Override
	public List<Orders> findAllOrders() {
		Session session = factory.getCurrentSession();
		String hql = "FROM Orders";//Entity=java class name
		List<Orders> orders = session.createQuery(hql, Orders.class).getResultList();
		return orders;
	}
}
