package com.java18.nikolaos.listColth.model;

import java.io.Serializable;
import java.sql.Blob;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity(name = "ClothBean")
@Table(name = "product") // 配到資料庫的product資料表
public class ClothBean implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private Integer id;
	@Column(name = "name")
	private String name;
	@Column(name = "descrip")
	private String descrip;
	@Column(name = "highlight")
	private String highlight;
	@Column(name = "actual_price")
	private Integer actualPrice;
	@Lob
	private Blob photo;
	@Column(name = "file_Name")
	private String file_Name;
	@Column(name = "mime_Type")
	private String mime_Type;
	@Column(name = "colorId")
	private Integer colorId;
	@Column(name = "sizeId")
	private Integer sizeId;
	@Column(name = "stock")
	private Integer stock;
	@Column(name = "category")
	private String category;
	
	@Column(name = "clothCategoryId")
	@Transient
	private Integer clothCategoryId;
	@ManyToOne(cascade = CascadeType.DETACH)
	@JoinColumn(name = "FK_ClothCategoryBean_Id")
//	@JsonIgnore
	private ClothCategoryBean clothCategoryBean;
	@Transient
//	@JsonIgnore
	private MultipartFile productImage;
	@Transient
	private String priceStr = null;

	public ClothBean() {
	}

	public ClothBean(Integer id, String name, String descrip, String highlight, Integer actualPrice, Blob photo,
			String file_Name, String mime_Type, Integer stock, String category,
			Integer clothCategoryId, ClothCategoryBean clothCategoryBean, MultipartFile productImage) {
		super();
		this.id = id;
		this.name = name;
		this.descrip = descrip;
		this.highlight = highlight;
		this.actualPrice = actualPrice;
		this.photo = photo;
		this.file_Name = file_Name;
		this.mime_Type = mime_Type;
		this.stock = stock;
		this.category = category;
		this.clothCategoryId = clothCategoryId;
		this.clothCategoryBean = clothCategoryBean;
		this.productImage = productImage;
	
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

	public String getDescrip() {
		return descrip;
	}

	public void setDescrip(String descrip) {
		this.descrip = descrip;
	}

	public String getHighlight() {
		return highlight;
	}

	public void setHighlight(String highlight) {
		this.highlight = highlight;
	}

	public Integer getActualPrice() {
		return actualPrice;
	}

	public void setActualPrice(Integer actualPrice) {
		this.actualPrice = actualPrice;
	}

	public Blob getPhoto() {
		return photo;
	}

	public void setPhoto(Blob photo) {
		this.photo = photo;
	}

	public String getFile_Name() {
		return file_Name;
	}

	public void setFile_Name(String file_Name) {
		this.file_Name = file_Name;
	}

	public String getMime_Type() {
		return mime_Type;
	}

	public void setMime_Type(String mime_Type) {
		this.mime_Type = mime_Type;
	}

	public Integer getColorId() {
		return colorId;
	}

	public void setColorId(Integer colorId) {
		this.colorId = colorId;
	}

	public Integer getSizeId() {
		return sizeId;
	}

	public void setSizeId(Integer sizeId) {
		this.sizeId = sizeId;
	}

	public Integer getStock() {
		return stock;
	}

	public void setStock(Integer stock) {
		this.stock = stock;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public Integer getClothCategoryId() {
		return clothCategoryId;
	}

	public void setClothCategoryId(Integer clothCategoryId) {
		this.clothCategoryId = clothCategoryId;
	}

	public ClothCategoryBean getClothCategoryBean() {
		return clothCategoryBean;
	}

	public void setClothCategoryBean(ClothCategoryBean clothCategoryBean) {
		this.clothCategoryBean = clothCategoryBean;
	}

	public MultipartFile getProductImage() {
		return productImage;
	}

	public void setProductImage(MultipartFile productImage) {
		this.productImage = productImage;
	}

	public String getPriceStr() {
		return priceStr;
	}

	public void setPriceStr(String priceStr) {
		this.priceStr = priceStr;
	}
	
	

	


}
