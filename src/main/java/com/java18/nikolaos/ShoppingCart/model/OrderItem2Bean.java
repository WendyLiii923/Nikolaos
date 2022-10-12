package com.java18.nikolaos.ShoppingCart.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity(name = "orderitems2Bean")
@Table(name = "orderitems2")
public class OrderItem2Bean {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer seqno;
	String highlight;
	Integer id;
	String clothcategoryName;
	String descrip;
	Integer orderNo;
	Integer quantity;
	String name;
	Integer actualPrice;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "FK_Order2Bean_orderNo")
	Order2Bean order2Bean;
	

	public OrderItem2Bean() {
	}

	public OrderItem2Bean(Integer seqno, String highlight, Integer id, String clothcategoryName, String descrip,
			Integer orderNo, Integer quantity, String name, Integer actualPrice) {
		super();
		this.seqno = seqno;
		this.highlight = highlight;
		this.id = id;
		this.clothcategoryName = clothcategoryName;
		this.descrip = descrip;
		this.orderNo = orderNo;
		this.quantity = quantity;
		this.name = name;
		this.actualPrice = actualPrice;
	}

	public Integer getSeqno() {
		return seqno;
	}

	public void setSeqno(Integer seqno) {
		this.seqno = seqno;
	}

	public String getHighlight() {
		return highlight;
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getClothcategoryName() {
		return clothcategoryName;
	}

	public void setClothcategoryName(String clothcategoryName) {
		this.clothcategoryName = clothcategoryName;
	}

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public Integer getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(Integer orderNo) {
		this.orderNo = orderNo;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(Integer actualPrice) {
		this.actualPrice = actualPrice;
	}

	public Order2Bean getOrder2Bean() {
		return order2Bean;
	}

	public void setOrder2Bean(Order2Bean order2Bean) {
		this.order2Bean = order2Bean;
	}
	

}
