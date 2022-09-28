package com.java18.nikolaos.used.model;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="members")
public class Members {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer	id;

	@Column(name="name")
    private String name;
	
	@Column(name="memberId")
	private String memberId;
	
	@Column(name="password")
	private String password;

    public Members(){
    	
    }
    
    public Members(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Members [id=" + id + ", name=" + name + "]";
	}
    
    
}
