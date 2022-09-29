package com.java18.nikolaos.used.model.service;

import java.util.List;

import com.java18.nikolaos.used.model.CartDetailView;
import com.java18.nikolaos.used.model.UsedCart;
import com.java18.nikolaos.used.model.UsedCartDetail;

public interface CartService {

	UsedCart getUncheckOutCart(Integer memberId);

	UsedCartDetail createCartDetail(Integer cartId, Integer productId, Integer productQty);

	void deleteProductFromCart(Integer memberId, Integer cartId, Integer productId);

	List<UsedCartDetail> getCartDetailList(Integer cartId);

	List<CartDetailView> getCartDetailInfo(Integer cartId);

	UsedCartDetail getCartDetail(Integer cartId);

	UsedCart updateCartStatus(Integer id);
	
	Integer getCartTotal(Integer cartId);

}