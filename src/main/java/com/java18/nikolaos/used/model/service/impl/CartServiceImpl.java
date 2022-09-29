package com.java18.nikolaos.used.model.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java18.nikolaos.general.model.dao.MembersDao;
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
	@Autowired
	MembersDao membersDao;
	
	private Integer totalPrice = 0;
	
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

		cartList.stream().forEach(c -> {
			totalPrice = totalPrice + c.getPrice() * c.getProductQty();
			
		});
		totalPrice = totalPrice + 60;
		return totalPrice;
	}
}
