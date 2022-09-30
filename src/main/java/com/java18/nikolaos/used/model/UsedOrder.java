package com.java18.nikolaos.used.model;

import java.sql.Timestamp;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
@Table(name = "used_order")
public class UsedOrder {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	@Column(name = "createTime")
	private Timestamp createTime = new Timestamp(System.currentTimeMillis());
	
	@Column(name = "memberId")
	private Integer memberId;
	
	@Column(name = "totalPrice")
	private Integer totalPrice;
	
	@Column(name = "shippingFee")
	private Integer shippingFee;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "phone")
	private String phone;
	
	@Transient
	private List<OrderDetailView> orderDetailViewList;
	
	public UsedOrder() {
		
	}

	public UsedOrder(Integer id, Timestamp createTime, Integer memberId, Integer totalPrice, Integer shippingFee,
			String email, String address, String phone) {
		super();
		this.id = id;
		this.createTime = createTime;
		this.memberId = memberId;
		this.totalPrice = totalPrice;
		this.shippingFee = shippingFee;
		this.email = email;
		this.address = address;
		this.phone = phone;
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

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(Integer totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Integer getShippingFee() {
		return shippingFee;
	}

	public void setShippingFee(Integer shippingFee) {
		this.shippingFee = shippingFee;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}
	
	public List<OrderDetailView> getOrderDetailViewList() {
		return orderDetailViewList;
	}

	public void setOrderDetailViewList(List<OrderDetailView> orderDetailviewList) {
		this.orderDetailViewList = orderDetailviewList;
	}

	@Override
	public String toString() {
		return "UsedOrder [id=" + id + ", createTime=" + createTime + ", memberId=" + memberId + ", totalPrice="
				+ totalPrice + ", shippingFee=" + shippingFee + ", email=" + email + ", address=" + address + ", phone="
				+ phone + "]";
	}

	
	
}
