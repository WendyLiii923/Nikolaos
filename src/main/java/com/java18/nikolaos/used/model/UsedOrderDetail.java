package com.java18.nikolaos.used.model;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "used_orderDetail")
public class UsedOrderDetail {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	@Column(name = "createTime")
	private Timestamp createTime = new Timestamp(System.currentTimeMillis());
	
	@Column(name = "orderId")
	private Integer orderId;
	
	@Column(name = "productId")
	private Integer productId;

	@Column(name = "productQty")
	private Integer productQty;
	
	
	public UsedOrderDetail() {
		
	}

	public UsedOrderDetail(Integer id, Timestamp createTime, Integer orderId, Integer productId, Integer productQty) {
		super();
		this.id = id;
		this.createTime = createTime;
		this.orderId = orderId;
		this.productId = productId;
		this.productQty = productQty;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Timestamp getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Timestamp createTime) {
		this.createTime = createTime;
	}

	public Integer getOrderId() {
		return orderId;
	}

	public void setOrderId(Integer orderId) {
		this.orderId = orderId;
	}

	public Integer getProductId() {
		return productId;
	}

	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	
	public Integer getProductQty() {
		return productQty;
	}
	
	public void setProductQty(Integer productQty) {
		this.productQty = productQty;
	}

	@Override
	public String toString() {
		return "UsedOrderDetail [id=" + id + ", createTime=" + createTime + ", orderId=" + orderId + ", productId="
				+ productId + ", productQty=" + productQty + "]";
	}
	
}
