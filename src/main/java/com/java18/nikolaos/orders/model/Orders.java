package com.java18.nikolaos.orders.model;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import org.hibernate.annotations.CreationTimestamp;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Orders {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "order_id")
	private Integer id;

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "member_id")
	private Members members;

	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
//	@Temporal(TemporalType.TIMESTAMP)
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
	@Transient
	private boolean ok_tag;
	private String recip_phone;

//	@ManyToOne(cascade = CascadeType.ALL)
//	private Integer shipping_method;

	public Orders() {
	}

//	public Orders(Integer id, Timestamp order_date, String shipping_address, Timestamp shipping_date, String recipient,
//			Double total_amount, Boolean cancel_tag, Boolean ok_tag, String recip_phone) {
//		super();
//		this.id = id;
//		this.order_date = order_date;
//		this.shipping_address = shipping_address;
//		this.shipping_date = shipping_date;
//		this.recipient = recipient;
//		this.total_amount = total_amount;
//		this.cancel_tag = cancel_tag;
//		this.ok_tag = ok_tag;
//		this.recip_phone = recip_phone;
//	}

	public Orders(String shipping_address, String recipient, Double total_amount, String recip_phone
//			,Members member_id
	) {
		super();
		this.shipping_address = shipping_address;
		this.recipient = recipient;
		this.total_amount = total_amount;
		this.recip_phone = recip_phone;
//		this.member_id = member_id;
	}

	public Orders(Integer id,
//			Integer member_id,
			Date order_date, String shipping_address, Timestamp shipping_date, String recipient, Double total_amount,
			boolean cancel_tag, boolean ok_tag, String recip_phone) {
		super();
		this.id = id;
//		this.member_id = member_id;
		this.order_date = order_date;
		this.shipping_address = shipping_address;
		this.shipping_date = shipping_date;
		this.recipient = recipient;
		this.total_amount = total_amount;
		this.cancel_tag = cancel_tag;
		this.ok_tag = ok_tag;
		this.recip_phone = recip_phone;
	}

	public void setCancel_tag(boolean cancel_tag) {
		this.cancel_tag = cancel_tag;
	}

	public void setOk_tag(boolean ok_tag) {
		this.ok_tag = ok_tag;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Boolean getOk_tag() {
		return ok_tag;
	}

	public void setOk_tag(Boolean ok_tag) {
		this.ok_tag = ok_tag;
	}

	public Integer getOrder_id() {
		return id;
	}

	public void setOrder_id(Integer order_id) {
		this.id = order_id;
	}

//	public Integer getMember_id() {
//		return member_id;
//	}
//
//	public void setMember_id(Integer member_id) {
//		this.member_id = member_id;
//	}

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

	public Boolean getCancel_tag() {
		return cancel_tag;
	}

	public void setCancel_tag(Boolean cancel_tag) {
		this.cancel_tag = cancel_tag;
	}

	public String getRecip_phone() {
		return recip_phone;
	}

	public void setRecip_phone(String recip_phone) {
		this.recip_phone = recip_phone;
	}

	public Members getMembers() {
		return members;
	}

	public void setMembers(Members members) {
		this.members = members;
	}

//	public Integer getShipping_method() {
//		return shipping_method;
//	}
//
//	public void setShipping_method(Integer shipping_method) {
//		this.shipping_method = shipping_method;
//	}
}
