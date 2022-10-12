package com.java18.nikolaos.ShoppingCart.model.dao.impl;

import java.sql.Connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java18.nikolaos.ShoppingCart.model.OrderItem2Bean;
import com.java18.nikolaos.ShoppingCart.model.dao.OrderItem2Dao;


@Repository
public class OrderItem2DaoImpl_Hibernate implements OrderItem2Dao {

	SessionFactory factory;
	

	
	@Autowired
	public OrderItem2DaoImpl_Hibernate(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public double findItemAmount(OrderItem2Bean oib) {
		double subtotal = oib.getQuantity()*oib.getActualPrice();
		return subtotal;
	}


	@Override
	public void updateProductStock(OrderItem2Bean orderItem2Bean) {
		String hql1 = "UPDATE ClothBean SET stock = stock - :orderAmount WHERE id = :id";	
		Session session = factory.getCurrentSession();
		
		session.createQuery(hql1)
		.setParameter("id",orderItem2Bean.getId())
		.setParameter("orderAmount",orderItem2Bean.getQuantity())
		.executeUpdate();
	}


	@Override
	public void setConnection(Connection conn) {
		throw new RuntimeException("OrderItemDaoImpl_Hibernate類別未實作此方法");
		
	}



	

}
