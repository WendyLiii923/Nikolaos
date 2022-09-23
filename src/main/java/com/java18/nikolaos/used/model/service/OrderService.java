package com.java18.nikolaos.used.model.service;

import java.util.List;

import com.java18.nikolaos.used.model.UsedCartDetail;
import com.java18.nikolaos.used.model.UsedOrderDetail;
import com.java18.nikolaos.used.model.dao.CartDao;
import com.java18.nikolaos.used.model.dao.CartDetailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java18.nikolaos.used.model.UsedOrder;
import com.java18.nikolaos.used.model.dao.OrderDao;
import com.java18.nikolaos.used.model.dao.OrderDetailDao;

@Service
@Transactional
public class OrderService {
	
	@Autowired
	OrderDao orderDao;
	@Autowired
	OrderDetailDao orderDetailDao;
	@Autowired
	CartDetailDao cartDetailDao;

	
	public UsedOrder createOrder(Integer memberId, Integer totalPrice, Integer shippingFee) {
		return orderDao.createOrder(memberId, totalPrice, shippingFee);
	}
	
	public List<UsedOrder> getOrderList(Integer orderId) {
		return orderDao.getOrderList(orderId);
	}
	
	public void addOrderDetail(Integer orderId, Integer cartId) {
		List<UsedCartDetail> cartDetails = cartDetailDao.getCartDetailList(cartId);
		for (UsedCartDetail cartDetail: cartDetails) {
			orderDetailDao.createOrderDetail(orderId, cartDetail);
		}
	}

	public List<UsedOrderDetail> getOrderDetailList(Integer orderId) {
		return orderDetailDao.getOrderDetailList(orderId);
	}

}
