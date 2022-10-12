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
@Table(name = "used_product")
public class UsedProduct {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	@Column(name = "createTime")
	private Timestamp createTime = new Timestamp(System.currentTimeMillis());
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "price")
	private Integer price;

	@Column(name = "content")
	private String content;

	@Column(name = "memberId")
	private Integer memberId;
	
	@Column(name = "categoryId")
	private Integer categoryId;

	@Column(name = "cover")
	private String cover;

	@Column(name = "status")
	private String status;

	public UsedProduct() {

	}

	public UsedProduct(Integer id, Timestamp createTime, String name, Integer price, String content, Integer memberId,
			Integer categoryId, String cover, String status) {
		super();
		this.id = id;
		this.createTime = createTime;
		this.name = name;
		this.price = price;
		this.content = content;
		this.memberId = memberId;
		this.categoryId = categoryId;
		this.cover = cover;
		this.status = status;
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

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getPrice() {
		return price;
	}

	public void setPrice(Integer price) {
		this.price = price;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Integer getMemberId() {
		return memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCover() {
		return cover;
	}

	public void setCover(String cover) {
		this.cover = cover;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "UsedProduct [id=" + id + ", createTime=" + createTime + ", name=" + name + ", price=" + price
				+ ", content=" + content + ", memberId=" + memberId + ", categoryId=" + categoryId + ", cover=" + cover
				+ ", status=" + status + "]";
	}

	
	



}
