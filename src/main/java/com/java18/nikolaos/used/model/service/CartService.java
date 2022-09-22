package com.java18.nikolaos.used.model.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java18.nikolaos.used.model.UsedCart;
import com.java18.nikolaos.used.model.UsedCartDetail;
import com.java18.nikolaos.used.model.dao.CartDao;
import com.java18.nikolaos.used.model.dao.CartDetailDao;

@Service
@Transactional
public class CartService {

	@Autowired
	CartDao cartDao;
	@Autowired
	CartDetailDao cartDetailDao;

	public UsedCart getUncheckOutCart(Integer memberId) {
		UsedCart uncheckOutCart = cartDao.getUncheckOutCart(memberId);
		if (uncheckOutCart == null) {
			return cartDao.createCart(memberId);
		} else {
			return uncheckOutCart;
		}
	}

	public UsedCartDetail createCartDetail(Integer cartId, Integer productId, Integer productQty) {
		return cartDetailDao.createCartDetail(cartId, productId, productQty);
	}
	
	public void deleteProductFromCart(Integer memberId, Integer cartId, Integer productId) {
		if (cartDao.getUncheckOutCart(memberId) != null) {
			cartDetailDao.deleteCartDetail(cartId, productId);
		}
	}
	
	public List<UsedCartDetail> getCartDetailList(Integer cartId, Integer productId) {
		return cartDetailDao.getCartDetail(cartId, productId);
	}
	
	public UsedCart updateCartStatus(Integer cartId) {
			return cartDao.updateStatus(cartId);
	}

}
