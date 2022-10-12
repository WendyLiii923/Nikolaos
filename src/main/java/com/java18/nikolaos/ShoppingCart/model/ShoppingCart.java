package com.java18.nikolaos.ShoppingCart.model;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
public class ShoppingCart {   
	
	private Map<Integer, OrderItem2Bean> cart = new LinkedHashMap< >();
	
	public ShoppingCart() {
	}
	
	public Map<Integer, OrderItem2Bean>  getContent() { // ${ShoppingCart.content}
		return cart;
	}
	public void addToCart(int id, OrderItem2Bean  oib) { //id bookId
		if (oib.getQuantity() <= 0 ) {
			return;
		}
		// 如果客戶在伺服器端沒有此項商品的資料，則客戶第一次購買此項商品
		if ( cart.get(id) == null ) {
		    cart.put(id, oib);
		} else {
	        // 如果客戶在伺服器端已有此項商品的資料，則客戶『加購』此項商品
			OrderItem2Bean oiBean = cart.get(id);
			// 加購的數量：bean.getQuantity()
			// 原有的數量：oBean.getQuantity()			
			oiBean.setQuantity(oib.getQuantity() + oiBean.getQuantity());
		}
	}

	public boolean modifyQty(int id, int newQty) {
		if ( cart.get(id) != null ) {
		   OrderItem2Bean  bean = cart.get(id);
		   bean.setQuantity(newQty);
	       return true;
		} else {
		   return false;
		}
	}
	// 刪除某項商品
	public int deleteCloth(int id) {
		if ( cart.get(id) != null ) {
	       cart.remove(id);  // Map介面的remove()方法
	       return 1;
		} else {
		   return 0;
		}
	}
	public int getItemNumber(){   // ShoppingCart.itemNumber
		return cart.size();
	}
	//計算購物車內所有商品的合計金額(每項商品的單價*數量的總和)
	public double getSubtotal(){
		double subTotal = 0 ;
		Set<Integer> set = cart.keySet();
		for(int n : set){
			OrderItem2Bean oib = cart.get(n);
			double price    = oib.getActualPrice();
			int qty      = oib.getQuantity();
			subTotal +=  price * qty;
		}
		return subTotal;
	}
}
