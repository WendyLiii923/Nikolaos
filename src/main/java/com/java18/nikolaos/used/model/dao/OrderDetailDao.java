package com.java18.nikolaos.used.model.dao;

import java.util.List;

import com.java18.nikolaos.used.model.UsedCartDetail;
import com.java18.nikolaos.used.model.UsedOrderDetail;

public interface OrderDetailDao {
//	產生一筆訂單細項
	UsedOrderDetail createOrderDetail(Integer orderId, UsedCartDetail usedCartDetail);
//	檢視所有訂單
	List<UsedOrderDetail> getOrderDetailList(Integer orderId);
	
}
