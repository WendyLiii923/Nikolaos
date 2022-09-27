package com.java18.nikolaos.used.model.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java18.nikolaos.used.model.UsedCartDetail;
import com.java18.nikolaos.used.model.UsedOrderDetail;
import com.java18.nikolaos.used.model.dao.OrderDetailDao;

@Repository
public class OrderDetailDaoImpl implements OrderDetailDao{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	private final String selectOrderDetailListByOrderId = "FROM com.java18.nikolaos.used.model.UsedOrderDetail WHERE orderId=:orderId";
	
	public OrderDetailDaoImpl() {
		
	}
	
	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}
	
	@Override
	public UsedOrderDetail createOrderDetail(Integer orderId, UsedCartDetail usedCartDetail) {
		UsedOrderDetail detail = new UsedOrderDetail();
		try {
			detail.setOrderId(orderId);
			detail.setProductId(usedCartDetail.getProductId());
			detail.setProductQty(usedCartDetail.getProductQty());
			getSession().save(detail);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return detail;
	}

	@Override
	public List<UsedOrderDetail> getOrderDetailList(Integer orderId) {
		Query<UsedOrderDetail> check = getSession().createQuery(selectOrderDetailListByOrderId, UsedOrderDetail.class);
		check.setParameter("orderId", orderId);
		List<UsedOrderDetail> list = check.list();
		return list;
	}


	

}
