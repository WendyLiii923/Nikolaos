package com.java18.nikolaos.register.model;

import java.io.Serializable;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;
@Entity
@Table(name="members")
public class MemberBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column
	Integer id;
	String name;
	String password;
	String email;
	String phone;
	String address;
	
	
//	String userType;
//	Timestamp registerTime;
//	Double totalAmt;
//	Blob memberImage;
//	String fileName;
//	String mimeType;
//	Clob comment;
//	Double unpaid_amount;
	
//	@Transient
//	MultipartFile memberMultipartFile;
	              
	@Transient
	String password1;


	public MemberBean(Integer id, String name, String password, String email, String phone,
			String address) {
		this.id = id;
		this.name = name;
		this.password = password;
		this.email = email;
		this.phone = phone;
		this.address = address;
		
//		this.userType = userType;
//		this.registerTime = registerTime;
//		this.totalAmt = totalAmt;
//		this.unpaid_amount = unpaid_amount;
	}


	public MemberBean() {
	}

	public Integer getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
	}

//	public Clob getComment() {
//		return comment;
//	}
//
//	public void setComment(Clob comment) {
//		this.comment = comment;
//	}
//
//	public void setUserType(String userType) {
//		this.userType = userType;
//	}
//
//	public void setTs(Timestamp ts) {
//		this.registerTime = ts;
//	}
//
//	public void setTotalAmt(Double totalAmt) {
//		this.totalAmt = totalAmt;
//	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String mail) {
		email = mail;
	}

//	public void setRegisterTime(Timestamp registerTime) {
//		this.registerTime = registerTime;
//	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

//	public String getUserType() {
//		return userType;
//	}
//
//	public Timestamp getRegisterTime() {
//		return registerTime;
//	}
//
//	public Double getTotalAmt() {
//		return totalAmt;
//	}
//
//	public Double getUnpaid_amount() {
//		return unpaid_amount;
//	}
//
//	public void setUnpaid_amount(Double unpaid_amount) {
//		this.unpaid_amount = unpaid_amount;
//	}

//	public MultipartFile getMemberMultipartFile() {
//		return memberMultipartFile;
//	}
//
//	public void setMemberMultipartFile(MultipartFile memberMultipartFile) {
//		this.memberMultipartFile = memberMultipartFile;
//	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password1) {
		this.password1 = password1;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("MemberBean [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", password=");
		builder.append(password);
		builder.append(", email=");
		builder.append(email);
		builder.append(", phone=");
		builder.append(phone);
		builder.append(", address=");
		builder.append(address);
//		builder.append(", userType=");
//		builder.append(userType);
//		builder.append(", registerTime=");
//		builder.append(registerTime);
//		builder.append(", totalAmt=");
//		builder.append(totalAmt);
//		builder.append(", comment=");
//		builder.append(comment);
//		builder.append(", unpaid_amount=");
//		builder.append(unpaid_amount);
		builder.append("]");
		return builder.toString();
	}
	
	
}
