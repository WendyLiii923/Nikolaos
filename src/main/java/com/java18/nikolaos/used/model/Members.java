package com.java18.nikolaos.used.model;


import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Entity
@Table(name="members")
public class Members {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer	id;

	@Column(name="name")
    private String name;

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

    public String getUserName() {
        return name;
    }

    public void setUserName(String name) {
        this.name = name;
    }

	@Override
	public String toString() {
		return "Members [id=" + id + ", name=" + name + "]";
	}
    
    
}
