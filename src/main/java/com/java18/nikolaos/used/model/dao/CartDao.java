package com.java18.nikolaos.used.model.dao;

import com.java18.nikolaos.used.model.UsedCart;

public interface CartDao {
	// 新增會員未結帳狀態的購物車
	public UsedCart createCart(Integer memberId);
	// 查詢會員未結帳狀態的購物車
	public UsedCart getUncheckOutCart(Integer memberId);
	// 更新購物車狀態(未結帳->結帳)
	public UsedCart updateStatus(Integer id);
	
}
