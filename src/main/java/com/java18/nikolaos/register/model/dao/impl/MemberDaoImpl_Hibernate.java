package com.java18.nikolaos.register.model.dao.impl;

import java.sql.Connection;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java18.nikolaos.register.model.dao.MemberDao;
import com.java18.nikolaos.register.model.MemberBean;
//import com.java18.nikolaos.ShoppingCart.model.OrderBean;
// 本類別使用JDBC技術存取資料庫。
@Repository
public class MemberDaoImpl_Hibernate implements MemberDao {
	
//	private static Logger log = LoggerFactory.getLogger(MemberDaoImpl_Hibernate.class);
	
	SessionFactory factory;
	@Autowired
	public MemberDaoImpl_Hibernate(SessionFactory factory) {
		this.factory = factory;
	}
	
	@Override
	// 儲存MemberBean物件，將參數mb新增到Member表格內。
	public void save(MemberBean mb) {
//		log.info("會員註冊功能之Dao: 儲存會員資料");
		Session session = factory.getCurrentSession();
		session.save(mb);
//		log.info("會員註冊功能之Dao: 新增成功：MemberBean=" + mb);
	}
	
	// 判斷參數id(會員帳號)是否已經被現有客戶使用，如果是，傳回true，表示此id不能使用，
	// 否則傳回false，表示此id可使用。
	@Override
	public boolean existsByEmail(String email) {
//		log.info("會員註冊功能之Dao: 檢查會員輸入的編號是否已被使用");
		boolean exist = false;
		String hql = "FROM MemberBean WHERE email = :memail ";
		Session session = factory.getCurrentSession();
		try {
			MemberBean bean = (MemberBean) session.createQuery(hql)
												  .setParameter("memail", email)
												  .getSingleResult();
			if (bean != null) {
				exist = true;
			}
		} catch(NoResultException e) {
			exist = false;
		} catch(NonUniqueResultException e) {
			exist = true;
		} 
//		log.info("會員註冊功能之Dao: 檢查會員輸入的編號是否已被使用, exist=" + exist);
		return exist;
	}
	
	// 由參數 id (會員帳號) 到Member表格中 取得某個會員的所有資料，傳回值為一個MemberBean物件，
	// 如果找不到對應的會員資料，傳回值為null。
	@Override
	public MemberBean findByEmail(String email) {
//		log.info("會員登入功能之Dao: 檢查帳號/密碼"); 
		MemberBean mb = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean m WHERE m.email = :memail";
		try {
			mb = (MemberBean) session.createQuery(hql)
									 .setParameter("memail", email)
									 .getSingleResult();
		} catch(NoResultException e) {
			mb = null;
		} 
//		log.info("會員登入功能之Dao: 取得某個會員的資料, mb=" + mb);
		return mb;
	}
	
	// 檢查使用者在登入時輸入的帳號與密碼是否正確。如果正確，傳回該帳號所對應的MemberBean物件，
	// 否則傳回 null。
	@Override
	public MemberBean findByEmailAndPassword(String email, String password) {
		MemberBean mb = null;
		Session session = factory.getCurrentSession();
		String hql = "FROM MemberBean m WHERE m.email = :memail and m.password = :pswd";
		try {
			mb = (MemberBean) session.createQuery(hql)
							.setParameter("memail", email)
							.setParameter("pswd", password)
							.getSingleResult();
		} catch(NoResultException e) {
			mb = null;
		} 
//		log.info("會員登入功能之Dao: 檢查帳號/密碼結果:" + 
//					(mb == null ? "帳號/密碼正確" : "帳號/密碼錯誤"));
		return mb;
	}
	/*
	*/
//	@Override
//	public void updateUnpaidAmount(OrderBean ob) {
//		log.info("處理訂單之memberDao: 更新MemberBean之未付款金額以便儲存最新的未付款餘額");
//		Session session = factory.getCurrentSession();
//		// 更新Member表格之未付款餘額欄位 unpaid_amount
//		String hql = "UPDATE MemberBean m "
//				+ " SET m.unpaid_amount = m.unpaid_amount + :totalAmount "
//				+ " WHERE m.memberId = :mid";
//
//		session.createQuery(hql).setParameter("totalAmount", ob.getTotalAmount())
//								.setParameter("mid", ob.getMemberId())
//								.executeUpdate();
//	}
	
	@Override
	public void setConnection(Connection conn) {
		throw new RuntimeException("不支援setConnection(Connection con)方法...");
	}
}
