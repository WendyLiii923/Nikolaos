package com.java18.nikolaos.register.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.java18.nikolaos.orders.model.Orders;

@Entity
@Table(name="members")
public class MemberBean  {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;
    String name;
    String password;
    String email;
    String phone;
    String address;

//    @OneToMany(mappedBy = "member",cascade = CascadeType.ALL)
//    @JsonManagedReference
//	private  Set<Orders> Orders;
    
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

        
    }


    public MemberBean() {
    }

    
//    public Set<Orders> getOrders() {
//		return Orders;
//	}
//
//
//	public void setOrders(Set<Orders> orders) {
//		Orders = orders;
//	}


	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


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
        builder.append("]");
        return builder.toString();
    }


}