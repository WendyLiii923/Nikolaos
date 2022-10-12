package com.java18.nikolaos.orders.model.dao;

import java.util.List;

import com.java18.nikolaos.orders.model.Orders;


public interface OrdersDao {
	//新增一筆訂單紀錄
	void saveOrder(Orders orders);
	//查詢單個會員的全部訂單
	Orders findById(Integer id);
	
	// 更新訂單內容
	void updateOrder(Orders orders);

	// 查詢所有訂單
	List<Orders> findAllOrders();

	void cancelOrder(Orders order);
	
	List<Orders> findByMemberId(Integer memberId); 

}