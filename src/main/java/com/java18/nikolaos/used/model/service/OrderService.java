package com.java18.nikolaos.used.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java18.nikolaos.used.model.OrderDetailView;
import com.java18.nikolaos.used.model.UsedCartDetail;
import com.java18.nikolaos.used.model.UsedOrder;
import com.java18.nikolaos.used.model.UsedOrderDetail;
import com.java18.nikolaos.used.model.dao.CartDetailDao;
import com.java18.nikolaos.used.model.dao.OrderDao;
import com.java18.nikolaos.used.model.dao.OrderDetailDao;
import com.java18.nikolaos.used.model.dao.OrderDetailViewDao;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderDetailDao orderDetailDao;
	@Autowired
	CartDetailDao cartDetailDao;
	@Autowired
	OrderDetailViewDao orderDetailViewDao;

	
	public UsedOrder createOrder(Integer memberId, Integer totalPrice, Integer shippingFee) {
		return orderDao.createOrder(memberId, totalPrice, shippingFee);
	}
	
	public List<UsedOrder> getOrderList(Integer memberId) {
		return orderDao.getOrderList(memberId);
	}
	
	public void addOrderDetail(Integer orderId, Integer cartId) {
		List<UsedCartDetail> cartDetails = cartDetailDao.getCartDetailList(cartId);//		System.out.println("訂單ID:" + orderId);
//		System.out.println("車ID:" + cartId);
		for (UsedCartDetail cartDetail: cartDetails) {
			orderDetailDao.createOrderDetail(orderId, cartDetail);
		}
	}

	public List<UsedOrderDetail> getOrderDetailList(Integer orderId) {
		return orderDetailDao.getOrderDetailList(orderId);
	}

	public List<OrderDetailView> getOrderDetailView(Integer orderId) {
		return orderDetailViewDao.getOrderDetailInfoById(orderId);
	}
	
	public UsedOrder getOrder(Integer orderId) {
		return orderDao.getOrderInfoById(orderId);
	}
}
