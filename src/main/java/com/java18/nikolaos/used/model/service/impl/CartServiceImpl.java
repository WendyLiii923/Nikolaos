package com.java18.nikolaos.used.model.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java18.nikolaos.used.model.CartDetailView;
import com.java18.nikolaos.used.model.UsedCart;
import com.java18.nikolaos.used.model.UsedCartDetail;
import com.java18.nikolaos.used.model.dao.CartDao;
import com.java18.nikolaos.used.model.dao.CartDetailDao;
import com.java18.nikolaos.used.model.service.CartService;
import com.java18.nikolaos.used.model.service.CollectService;

@Service
@Transactional
public class CartServiceImpl implements CartService {

	@Autowired
	CartDao cartDao;
	@Autowired
	CartDetailDao cartDetailDao;
	@Autowired
	CollectService collectService;

	
	
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
	public Map<String, String> addToCart(Integer cartId, Integer productId, Integer productQty) {
		HashMap<String,	String> map = new HashMap<>();
		UsedCartDetail cartDetail = cartDetailDao.createCartDetail(cartId, productId, productQty);
		if (cartDetail == null) {
			map.put("fail", "尚未加入購物車，請稍後再試");
		}else {
			map.put("success", "成功加入購物車");
		}
		return map;
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
