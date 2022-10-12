package com.java18.nikolaos.orders.model.service.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.java18.nikolaos.orders.model.Shippingmethod;
import com.java18.nikolaos.orders.model.dao.ShippingmethodDao;
import com.java18.nikolaos.orders.model.service.ShippingmethodService;

public class ShippingmethodServiceImpl implements ShippingmethodService {

	ShippingmethodDao shippingmethodDao;
	@Autowired
	public ShippingmethodServiceImpl(ShippingmethodDao shippingmethodDao) {
		this.shippingmethodDao = shippingmethodDao;
	}
	
	@Override
	public Shippingmethod finById(Integer id) {
		return shippingmethodDao.getNameById(id);
	}
	
}
