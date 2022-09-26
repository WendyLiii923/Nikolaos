package com.java18.nikolaos.used.model.dao;

import java.util.List;

import com.java18.nikolaos.used.model.OrderDetailView;

public interface OrderDetailViewDao {
	
	public List<OrderDetailView> getOrderDetailInfoById(Integer orderId);

}
