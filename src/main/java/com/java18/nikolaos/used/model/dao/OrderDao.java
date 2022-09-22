package com.java18.nikolaos.used.model.dao;

import java.util.List;

import com.java18.nikolaos.used.model.UsedOrder;

public interface OrderDao {
//	產生訂單
	UsedOrder createOrder(Integer memberId, Integer totalPrice, Integer shippingFee);
//	檢視所有訂單
	List<UsedOrder> getOrderList(Integer memberId);
	
}
