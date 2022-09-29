package com.java18.nikolaos.used.model.service;

import java.util.List;

import com.java18.nikolaos.used.model.OrderDetailView;
import com.java18.nikolaos.used.model.UsedOrder;
import com.java18.nikolaos.used.model.UsedOrderDetail;

public interface OrderService {

	UsedOrder createOrder(Integer memberId, Integer totalPrice, Integer shippingFee, String email, String address, String phone);

	List<UsedOrder> getOrderList(Integer memberId);

	void addOrderDetail(Integer orderId, Integer cartId);

	List<UsedOrderDetail> getOrderDetailList(Integer orderId);

	List<OrderDetailView> getOrderDetailView(Integer orderId);

	UsedOrder getOrder(Integer orderId);

}