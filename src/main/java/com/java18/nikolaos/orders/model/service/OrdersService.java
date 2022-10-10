package com.java18.nikolaos.orders.model.service;

import java.util.List;

import com.java18.nikolaos.orders.model.Orders;

public interface OrdersService {
	
	void saveOrder(Orders orders);
	
	Orders findById(Integer id);
	
	void updateOrder(Orders orders);
	
	List<Orders> findAllOrders();
	
	public void cancelOrder(Orders order);

}
