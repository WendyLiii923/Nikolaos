package com.java18.nikolaos.used.model.dao.impl;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java18.nikolaos.used.model.UsedCart;
import com.java18.nikolaos.used.model.dao.CartDao;

@Repository
public class CartDaoImpl implements CartDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private final String selectCartByMemberId ="FROM com.java18.nikolaos.used.model.UsedCart WHERE memberId=:memberId AND status=TRUE";
	private final String selectCartById="FROM com.java18.nikolaos.used.model.UsedCart WHERE id=:cartId AND status=TRUE";
	
	private Session getsession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	public CartDaoImpl() {
		
	}

	@Override
	public UsedCart createCart(Integer memberId) {
		UsedCart usedCart = new UsedCart();
		try {
			usedCart.setStatus(true);
			usedCart.setMemberId(memberId);
			getsession().save(usedCart);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usedCart;
	}	

	@Override
	public UsedCart getUncheckOutCart(Integer memberId) {
		Query<UsedCart> check = getsession().createQuery(selectCartByMemberId, UsedCart.class);
		check.setParameter("memberId", memberId);
		UsedCart aCart = check.setMaxResults(1)
				              .getResultList()
				              .stream()
				              .findFirst()
				              .orElse(null);
		return aCart;
		}
//		Query<UsedCart> check = getsession().createQuery(selectCartIdByMemberId, UsedCart.class);
//		try {
//			check.setParameter("MEMBERID", memberId);
//			UsedCart aCart = check.getSingleResult();
//			return aCart;
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}


	@Override
	public UsedCart updateStatus(Integer id) {
		Query<UsedCart> check = getsession().createQuery(selectCartById, UsedCart.class);
		check.setParameter("cartId", id);
		UsedCart updateItem = check.setMaxResults(1)
								.getResultList()
								.stream()
								.findFirst()
								.orElse(null);
		updateItem.setStatus(false);
		getsession().save(updateItem);
		return updateItem;
	}


	

}
