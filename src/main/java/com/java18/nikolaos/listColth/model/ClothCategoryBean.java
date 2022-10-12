package com.java18.nikolaos.listColth.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "cloth_category")
public class ClothCategoryBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "category")
	private String category;
	@Column(name = "parentId")
	private Integer parentId;
	@OneToMany(mappedBy = "clothCategoryBean")
	private Set<ClothBean> clothes;

	public ClothCategoryBean() {
	}

//	public ClothCategoryBean(Integer id, String category) {
//		this.id = id;
//		this.category = category;
//	}

	public ClothCategoryBean(Integer id, String category, Integer parentId) {
		this.id = id;
		this.category = category;
		this.parentId = parentId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getParentId() {
		return parentId;
	}

	public void setParentId(Integer parentId) {
		this.parentId = parentId;
	}

	public Set<ClothBean> getClothes() {
		return clothes;
	}

	public void setClothes(Set<ClothBean> clothes) {
		this.clothes = clothes;
	}

}
