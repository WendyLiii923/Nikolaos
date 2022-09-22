package com.java18.nikolaos.used.model.dao;

import java.util.List;

import com.java18.nikolaos.used.model.UsedCartDetail;

public interface CartDetailDao {
//	新增購物車細項
	public UsedCartDetail createCartDetail(Integer cartId, Integer productId, Integer productQty);
//	查詢購物車細項
	public List<UsedCartDetail> getCartDetail(Integer cartId, Integer productId);
//	移除購物車內商品
	public void deleteCartDetail(Integer cartId, Integer productId);
	
	
}
