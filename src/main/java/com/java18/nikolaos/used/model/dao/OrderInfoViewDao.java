package com.java18.nikolaos.used.model.dao;

import com.java18.nikolaos.used.model.OrderDetailView;

public interface OrderInfoViewDao {
	
	public OrderDetailView getOrderInfoById(Integer orderId);

}
