package com.java18.nikolaos.ShoppingCart.model.dao;

import java.sql.Connection;
import java.util.List;

import com.java18.nikolaos.ShoppingCart.model.Order2Bean;

public interface Order2Dao {

	
	void save (Order2Bean ob);
	
	Order2Bean findById(int orderNo);
	
	List<Order2Bean> findByMemberId(String memberId);
	
	void setConnection(Connection con);
		

}
