package com.java18.nikolaos.orders.model;

import java.sql.Timestamp;
import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.java18.nikolaos.ShoppingCart.model.OrderItem2Bean;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "member_id")
	private Integer member;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@CreationTimestamp
	private Date order_date;

	private String shipping_address;
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
	@Column(insertable = false)
	private Timestamp shipping_date;

	private String recipient;

	@Column(columnDefinition = "decimal(11,1) NOT NULL")
	private Double total_amount;

	private boolean cancel_tag;
	
	private boolean ok_tag;
	
	private String recip_phone;
	
	private Integer shipping_method;

	@OneToMany(mappedBy = "orders",cascade = CascadeType.ALL)
	private  Set<OrderItem2Bean> orderItem2Bean;
	
	public Integer getMember() {
		return member;
	}

	

	public Set<OrderItem2Bean> getOrderItem2Bean() {
		return orderItem2Bean;
	}



	public void setOrderItem2Bean(Set<OrderItem2Bean> orderItem2Bean) {
		this.orderItem2Bean = orderItem2Bean;
	}



	public void setMember(Integer member) {
		this.member = member;
	}
	


	public Integer getShipping_method() {
		return shipping_method;
	}

	public void setShipping_method(Integer shipping_method) {
		this.shipping_method = shipping_method;
	}

	public Orders() {
	}


	public Orders(String shipping_address, String recipient, Double total_amount, String recip_phone
	) {
		super();
		this.shipping_address = shipping_address;
		this.recipient = recipient;
		this.total_amount = total_amount;
		this.recip_phone = recip_phone;
	}

	public Orders(Integer id,
			Date order_date, String shipping_address, Timestamp shipping_date, String recipient, Double total_amount,
			boolean cancel_tag, boolean ok_tag, String recip_phone) {
		super();
		this.id = id;
		this.order_date = order_date;
		this.shipping_address = shipping_address;
		this.shipping_date = shipping_date;
		this.recipient = recipient;
		this.total_amount = total_amount;
		this.cancel_tag = cancel_tag;
		this.ok_tag = ok_tag;
		this.recip_phone = recip_phone;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}


	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public String getShipping_address() {
		return shipping_address;
	}

	public void setShipping_address(String shipping_address) {
		this.shipping_address = shipping_address;
	}

	public Timestamp getShipping_date() {
		return shipping_date;
	}

	public void setShipping_date(Timestamp shipping_date) {
		this.shipping_date = shipping_date;
	}

	public String getRecipient() {
		return recipient;
	}

	public void setRecipient(String recipient) {
		this.recipient = recipient;
	}

	public Double getTotal_amount() {
		return total_amount;
	}

	public void setTotal_amount(Double total_amount) {
		this.total_amount = total_amount;
	}

	public boolean getCancel_tag() {
		return cancel_tag;
	}

	public void setCancel_tag(boolean cancel_tag) {
		this.cancel_tag = cancel_tag;
	}

	public boolean getOk_tag() {
		return ok_tag;
	}

	public void setOk_tag(boolean ok_tag) {
		this.ok_tag = ok_tag;
	}

	public String getRecip_phone() {
		return recip_phone;
	}

	public void setRecip_phone(String recip_phone) {
		this.recip_phone = recip_phone;
	}

}
