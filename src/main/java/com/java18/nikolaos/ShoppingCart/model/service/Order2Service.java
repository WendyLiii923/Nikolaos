package com.java18.nikolaos.ShoppingCart.model.service;

import java.util.List;

import com.java18.nikolaos.ShoppingCart.model.Order2Bean;
import com.java18.nikolaos.ShoppingCart.model.ShoppingCart;

public interface Order2Service {

	
	
	void persistOrder(Order2Bean ob);
	
	Order2Bean findById(int orderNo);
	
	List<Order2Bean> findByMemberId(String memberId);
	
	void preCheckStock(ShoppingCart shoppingCart);
	
	
	
	
	
	
	

}
