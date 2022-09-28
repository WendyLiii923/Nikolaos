package com.java18.nikolaos.used.model.service.impl;

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
import com.java18.nikolaos.used.model.service.OrderService;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
	
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderDetailDao orderDetailDao;
	@Autowired
	CartDetailDao cartDetailDao;
	@Autowired
	OrderDetailViewDao orderDetailViewDao;

	
	@Override
	public UsedOrder createOrder(Integer memberId, Integer totalPrice, Integer shippingFee, String email, String address, String phone) {
		return orderDao.createOrder(memberId, totalPrice, shippingFee, email, address, phone);
	}
	
	@Override
	public List<UsedOrder> getOrderList(Integer memberId) {
		return orderDao.getOrderList(memberId);
	}
	
	@Override
	public void addOrderDetail(Integer orderId, Integer cartId) {
		List<UsedCartDetail> cartDetails = cartDetailDao.getCartDetailList(cartId);		for (UsedCartDetail cartDetail: cartDetails) {
			orderDetailDao.createOrderDetail(orderId, cartDetail);
		}
	}

	@Override
	public List<UsedOrderDetail> getOrderDetailList(Integer orderId) {
		return orderDetailDao.getOrderDetailList(orderId);
	}

	@Override
	public List<OrderDetailView> getOrderDetailView(Integer orderId) {
		return orderDetailViewDao.getOrderDetailInfoById(orderId);
	}
	
	@Override
	public UsedOrder getOrder(Integer orderId) {
		return orderDao.getOrderInfoById(orderId);
	}
}
