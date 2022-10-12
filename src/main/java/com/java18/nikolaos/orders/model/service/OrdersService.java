package com.java18.nikolaos.orders.model.service;

import java.util.List;

import com.java18.nikolaos.orders.model.Orders;

public interface OrdersService {
	
	void saveOrder(Orders orders);
	
	
	void updateOrder(Orders orders);
	
	List<Orders> findAllOrders();
	
	void cancelOrder(Orders order);


	Orders findById(Integer id);

}
