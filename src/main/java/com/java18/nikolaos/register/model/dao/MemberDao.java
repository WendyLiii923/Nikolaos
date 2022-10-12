package com.java18.nikolaos.register.model.dao;

import java.sql.Connection;

import com.java18.nikolaos.register.model.MemberBean;
//import com.java18.nikolaos.ShoppingCart.model.OrderBean;

public interface MemberDao {
	
	boolean existsByEmail(String email);

	void save(MemberBean mb) ;
	
	MemberBean findByEmail(String email);
	
	MemberBean findByEmailAndPassword(String email, String password);	
	
//	void updateUnpaidAmount(OrderBean ob);

	void setConnection(Connection con);

	void updateMember(MemberBean bean);
	
	MemberBean findById(Integer id); 
}