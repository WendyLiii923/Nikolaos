package com.java18.nikolaos.orders.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java18.nikolaos.orders.model.Orders;
import com.java18.nikolaos.orders.model.dao.OrdersDao;
import com.java18.nikolaos.orders.model.service.OrdersService;

@Service
@Transactional
public class OrderServiceImpl implements OrdersService {

	OrdersDao od;

	@Autowired
	public OrderServiceImpl(OrdersDao od) {
		this.od = od;
	}

	@Override
	public void saveOrder(Orders orders) {
		od.saveOrder(orders);
	}

	@Override
	public Orders findById(Integer id) {
		return od.findById(id);
	}

	@Override
	public void updateOrder(Orders orders) {
		od.updateOrder(orders);
	}

	@Override
	public List<Orders> findAllOrders() {
		return od.findAllOrders();
	}

}
