package com.java18.nikolaos.orders.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.java18.nikolaos.orders.model.Shippingmethod;
import com.java18.nikolaos.orders.model.dao.ShippingmethodDao;

public class ShippingmethodDaoImpl implements ShippingmethodDao {

	SessionFactory factory;

	@Autowired
	public ShippingmethodDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}

	@Override
	public Shippingmethod getNameById(Integer id) {
		Session session = factory.getCurrentSession();
		
		return session.get(Shippingmethod.class, id);
	}
}
