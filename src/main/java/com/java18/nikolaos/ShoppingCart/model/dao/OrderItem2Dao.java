package com.java18.nikolaos.ShoppingCart.model.dao;

import java.sql.Connection;

import com.java18.nikolaos.ShoppingCart.model.Order2Bean;
import com.java18.nikolaos.ShoppingCart.model.OrderItem2Bean;

public interface OrderItem2Dao {

	double findItemAmount(OrderItem2Bean oib);
	
	void updateProductStock(OrderItem2Bean ob);
	
	void setConnection (Connection conn);

}
