package com.java18.nikolaos.used.model.dao;

import java.util.List;

import com.java18.nikolaos.used.model.UsedOrder;

public interface OrderDao {
//	產生一筆訂單
	UsedOrder createOrder(Integer memberId, Integer totalPrice, Integer shippingFee, String email, String address, String phone);
//	檢視某會員的訂單List
	List<UsedOrder> getOrderList(Integer memberId);
//	找某一筆訂單
	UsedOrder getOrderInfoById(Integer orderId);
	
}
