package com.java18.nikolaos.register.model.service;

import com.java18.nikolaos.register.model.MemberBean;
//import com.java18.nikolaos.ShoppingCart.model.OrderBean;

public interface MemberService {
	boolean existsByEmail(String email);
	
	void save(MemberBean mb);
	
//	void checkUnpaidAmount(OrderBean ob);
	
	MemberBean findByEmail(String email);
	
	MemberBean findByEmailAndPassword(String email, String password) ;
}
