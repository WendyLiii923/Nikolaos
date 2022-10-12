package com.java18.nikolaos.ShoppingCart.model.service;

import java.util.List;

import com.java18.nikolaos.ShoppingCart.model.ShoppingCart;
import com.java18.nikolaos.orders.model.Orders;

public interface Order2Service {

	
	
	void persistOrder(Orders ob);
	
	Orders findById(int orderNo);
	
	List<Orders> findByMemberId(Integer memberId);
	
	void preCheckStock(ShoppingCart shoppingCart);
	
	
	
	
	
	
	

}
