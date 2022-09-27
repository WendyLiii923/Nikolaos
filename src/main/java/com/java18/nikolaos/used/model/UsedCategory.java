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
@Table(name = "used_category")
public class UsedCategory {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	
	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	@Column(name = "createTime")
	private Timestamp createTime = new Timestamp(System.currentTimeMillis());
	
	@Column(name = "name")
	private String name;

	@Column(name = "parentId")
	private Integer parentId;
	
	public UsedCategory() {
		
	}
	
	public UsedCategory(Timestamp createTime, Integer id, String name, Integer parentId) {
		this.id = id;
		this.createTime = createTime;
		this.name = name;
		this.parentId = parentId;
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

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	@Override
	public String toString() {
		return "UsedCategory [createTime=" + createTime + ", id=" + id + ", name=" + name + ", parentId=" + parentId
				+ "]";
	}
	
}
