package com.java18.nikolaos.ShoppingCart.model.service.impl;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java18.nikolaos.ShoppingCart.model.Order2Bean;
import com.java18.nikolaos.ShoppingCart.model.OrderItem2Bean;
import com.java18.nikolaos.ShoppingCart.model.ShoppingCart;
import com.java18.nikolaos.ShoppingCart.model.dao.Order2Dao;
import com.java18.nikolaos.ShoppingCart.model.dao.OrderItem2Dao;
import com.java18.nikolaos.ShoppingCart.model.service.Order2Service;
import com.java18.nikolaos.ShoppingCart.model.ude.ProductStockException;
import com.java18.nikolaos.listColth.model.dao.ClothDao;

@Service
@Transactional
public class Order2ServiceImpl implements Order2Service {

	
	private ClothDao clothDao;
	private OrderItem2Dao orderItem2Dao;
	private Order2Dao order2Dao;
//	private MemberDao memberDao;
	
	
	@Autowired
	public Order2ServiceImpl(ClothDao clothDao, OrderItem2Dao orderItem2Dao, Order2Dao order2Dao) {
		this.clothDao = clothDao;
		this.orderItem2Dao = orderItem2Dao;
		this.order2Dao = order2Dao;
	}


	@Override
	public void persistOrder(Order2Bean ob) {
		double currentAmount = ob.getTotalAmount();		
		checkStock(ob);
		order2Dao.save(ob);
		
	}
	
	public void checkStock(Order2Bean ob) {
		Set<OrderItem2Bean> items = ob.getItems();
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
	public Order2Bean findById(int orderNo) {
		Order2Bean bean =null;
		bean=order2Dao.findById(orderNo);
		return bean;
	}

	@Override
	public List<Order2Bean> findByMemberId(String memberId) {
		List<Order2Bean> list =null;
		list = order2Dao.findByMemberId(memberId);
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
