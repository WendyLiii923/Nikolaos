package com.java18.nikolaos.used.model.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java18.nikolaos.used.model.UsedCartDetail;

@Repository
public class CartDetailDaoImpl implements CartDetailDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private final String selectProductsByCartIdAndProductId = "FROM com.java18.nikolaos.used.model.UsedCartDetail "
			+ "WHERE cartId=:CARTID AND productId=:PRODUCTID";
	private final String selectProductsByCartId = "FROM com.java18.nikolaos.used.model.UsedCartDetail "
			+ "WHERE cartId=:CARTID";
	
	private Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	public CartDetailDaoImpl() {
	
	}

	@Override
	public UsedCartDetail createCartDetail(Integer cartId, Integer productId, Integer productQty) {
		UsedCartDetail usedCartDetail = new UsedCartDetail();
		try {
			usedCartDetail.setCartId(cartId);
			usedCartDetail.setProductId(productId);
			usedCartDetail.setProductQty(productQty);
			getSession().save(usedCartDetail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usedCartDetail;
	}

	@Override
	public List<UsedCartDetail> getCartDetailList(Integer cartId) {
		Query<UsedCartDetail> check = getSession().createQuery(selectProductsByCartId, UsedCartDetail.class);
		check.setParameter("CARTID", cartId);
		List<UsedCartDetail> list = check.list();
		return list;
	}

	@Override
	public void deleteCartDetail(Integer cartId, Integer productId) {
		Query<UsedCartDetail> check = getSession().createQuery(selectProductsByCartIdAndProductId, UsedCartDetail.class);
		check.setParameter("CARTID", cartId);
		check.setParameter("PRODUCTID", productId);
		UsedCartDetail aDetail = check.setMaxResults(1)
										 .getResultList()
										 .stream()
										 .findFirst()
										 .orElse(null);
		if (aDetail != null) {
			getSession().delete(aDetail);
		}else {
			System.out.println("NO PRODUCT");
		}
	}
	

}
