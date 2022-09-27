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
@Table(name = "used_chat")
public class UsedChat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;

	@JsonFormat(pattern = "yyyy-MM-dd hh:mm")
	@Column(name = "createTime")
	private Timestamp createTime = new Timestamp(System.currentTimeMillis());

	@Column(name = "fromId")
	private Integer fromId;

	@Column(name = "toId")
	private Integer toId;

	@Column(name = "content")
	private String content;
	
	public UsedChat() {
		
	}

	public UsedChat(Integer id, Timestamp createTime, Integer fromId, Integer toId, String content) {
		super();
		this.id = id;
		this.createTime = createTime;
		this.fromId = fromId;
		this.toId = toId;
		this.content = content;
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

	public Integer getFromId() {
		return fromId;
	}

	public void setFromId(Integer fromId) {
		this.fromId = fromId;
	}

	public Integer getToId() {
		return toId;
	}

	public void setToId(Integer toId) {
		this.toId = toId;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	@Override
	public String toString() {
		return "UsedChat [id=" + id + ", createTime=" + createTime + ", fromId=" + fromId + ", toId=" + toId
				+ ", content=" + content + "]";
	}

}
