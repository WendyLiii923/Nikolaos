package com.java18.nikolaos.used.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java18.nikolaos.used.model.CartDetailView;
import com.java18.nikolaos.used.model.UsedCart;
import com.java18.nikolaos.used.model.UsedCartDetail;
import com.java18.nikolaos.used.model.dao.CartDao;
import com.java18.nikolaos.used.model.dao.CartDetailDao;
import com.java18.nikolaos.used.model.service.CartService;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	CartDao cartDao;
	@Autowired
	CartDetailDao cartDetailDao;

	
	
	@Override
	public UsedCart getUncheckOutCart(Integer memberId) {
		UsedCart uncheckOutCart = cartDao.getUncheckOutCart(memberId);
		if (uncheckOutCart == null) {
			return cartDao.createCart(memberId);
		} else {
			return uncheckOutCart;
		}
	}

	@Override
	public UsedCartDetail createCartDetail(Integer cartId, Integer productId, Integer productQty) {
		return cartDetailDao.createCartDetail(cartId, productId, productQty);
	}

	@Override
	public void deleteProductFromCart(Integer memberId, Integer cartId, Integer productId) {
		if (cartDao.getUncheckOutCart(memberId) != null) {
			cartDetailDao.deleteCartDetail(cartId, productId);
		}
	}

	@Override
	public List<UsedCartDetail> getCartDetailList(Integer cartId) {
		return cartDetailDao.getCartDetailList(cartId);
	}

	@Override
	public List<CartDetailView> getCartDetailInfo(Integer cartId) {
		System.out.println("cartId:"+ cartId);
		return cartDetailDao.getCartDetailInfoById(cartId);
	}

	@Override
	public UsedCartDetail getCartDetail(Integer cartId) {
		return cartDetailDao.getCartDetail(cartId);
	}

	@Override
	public UsedCart updateCartStatus(Integer id) {
		
			return cartDao.updateStatus(id);
	}
	
	@Override
	public Integer getCartTotal(Integer cartId) {
		List<CartDetailView> cartList = cartDetailDao.getCartDetailInfoById(cartId);

		Integer totalPrice = 0;
		
		for(int n = 0; n < cartList.size(); n++ ) {
			totalPrice = totalPrice + cartList.get(n).getPrice() * cartList.get(n).getProductQty();
		}
		
		totalPrice += 60;
		return totalPrice;
	}
}
