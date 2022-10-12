package com.java18.nikolaos.ShoppingCart.model.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java18.nikolaos.ShoppingCart.model.OrderItem2Bean;
import com.java18.nikolaos.ShoppingCart.model.ShoppingCart;
import com.java18.nikolaos.ShoppingCart.model.dao.OrderItem2Dao;
import com.java18.nikolaos.ShoppingCart.model.service.Order2Service;
import com.java18.nikolaos.ShoppingCart.model.ude.ProductStockException;
import com.java18.nikolaos.listColth.model.dao.ClothDao;
import com.java18.nikolaos.orders.model.Orders;
import com.java18.nikolaos.orders.model.dao.OrdersDao;

@Service
@Transactional
public class Order2ServiceImpl implements Order2Service {

	
	private ClothDao clothDao;
	private OrderItem2Dao orderItem2Dao;
	private OrdersDao ordersDao;
	
	
	
	public Order2ServiceImpl() {
	}


	@Autowired
	public Order2ServiceImpl(ClothDao clothDao, OrderItem2Dao orderItem2Dao, OrdersDao ordersDao) {
		this.clothDao = clothDao;
		this.orderItem2Dao = orderItem2Dao;
		this.ordersDao = ordersDao;
	}


	@Override
	public void persistOrder(Orders ob) {
//		double currentAmount = ob.getTotal_amount();		
		checkStock(ob);
		ordersDao.saveOrder(ob);
		
	}
	
	public void checkStock(Orders ob) {
		Set<OrderItem2Bean> items = ob.getOrderItem2Bean();
		for(OrderItem2Bean oib:items) {
			int stock = clothDao.findById(oib.getId()).getStock();
			if(stock < oib.getQuantity()) {
				throw new ProductStockException(
						"庫存數量不足: id:"+oib.getId()+", 在庫量:"+stock+", 訂購量:"+oib.getQuantity()
						);
			}else {
				orderItem2Dao.updateProductStock(oib);
			}
		}
	}
	


	@Override
	public Orders findById(int orderNo) {
		Orders bean =null;
		bean=ordersDao.findById(orderNo);
		return bean;
	}

	@Override
	public List<Orders> findByMemberId(Integer memberId) {
		List<Orders> list =null;
		list = ordersDao.findByMemberId(memberId);
		return list;
	}

	@Override
	public void preCheckStock(ShoppingCart shoppingCart) {
		Set<Integer> set = shoppingCart.getContent().keySet();
		for(Integer i : set) {
			OrderItem2Bean oib = shoppingCart.getContent().get(i);
			int stock = clothDao.findById(oib.getId()).getStock();
			if(stock < oib.getQuantity()) {
				throw new ProductStockException("庫存數量不足: 商品: "
						+oib.getDescrip()+", 在庫量:"+stock+", 訂購量: "+oib.getQuantity()
						);
			}
		}
		
	}

}
