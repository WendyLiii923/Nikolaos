package com.java18.nikolaos.ShoppingCart.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity(name = "Order2Bean")
@Table(name = "Orders2")
public class Order2Bean {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "orderNo")
	Integer id;
	String bno;
	String cancelTag;
	String invoiceTitle;
	Integer memberId;
	Date orderDate;
	String shippingAddress;
	Date shippingDate;
	Double totalAmount;

	
	@OneToMany(mappedBy = "order2Bean",cascade = CascadeType.ALL)
//	Set<OrderItem2Bean> items = new LinkedHashSet<>();
	Set<OrderItem2Bean> items;
	
	
//	public Order2Bean(Object object, String bno2, String invoiceTitle2, Integer memberId2, String shippingAddress2, double totalAmount2, Date today, Object object2, Object object3) {
//	}

	public Order2Bean(Integer id, String bno, String cancelTag, String invoiceTitle, Integer memberId, Date orderDate,
			String shippingAddress, Date shippingDate, Double totalAmount, Set<OrderItem2Bean> items) {
		super();
		this.id = id;
		this.bno = bno;
		this.cancelTag = cancelTag;
		this.invoiceTitle = invoiceTitle;
		this.memberId = memberId;
		this.orderDate = orderDate;
		this.shippingAddress = shippingAddress;
		this.shippingDate = shippingDate;
		this.totalAmount = totalAmount;
		this.items = items;
		
	}

	public Order2Bean() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getBno() {
		return bno;
	}

	public void setBno(String bno) {
		this.bno = bno;
	}

	public String getCancelTag() {
		return cancelTag;
	}

	public void setCancelTag(String cancelTag) {
		this.cancelTag = cancelTag;
	}

	public String getInvoiceTitle() {
		return invoiceTitle;
	}

	public void setInvoiceTitle(String invoiceTitle) {
		this.invoiceTitle = invoiceTitle;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Date getOrderDate() {
		return orderDate;
	}

	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}

	public String getShippingAddress() {
		return shippingAddress;
	}

	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}

	public Date getShippingDate() {
		return shippingDate;
	}

	public void setShippingDate(Date shippingDate) {
		this.shippingDate = shippingDate;
	}

	public Double getTotalAmount() {
		return totalAmount;
	}

	public void setTotalAmount(Double totalAmount) {
		this.totalAmount = totalAmount;
	}

	public Set<OrderItem2Bean> getItems() {
		return items;
	}

	public void setItems(Set<OrderItem2Bean> items) {
		this.items = items;
	}
	

}
