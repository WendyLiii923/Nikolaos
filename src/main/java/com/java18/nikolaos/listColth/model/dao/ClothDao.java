package com.java18.nikolaos.listColth.model.dao;

import java.util.List;
import java.util.Map;

import com.java18.nikolaos.listColth.model.ClothBean;
import com.java18.nikolaos.listColth.model.ClothCategoryBean;



public interface ClothDao {
	//看所有商品
	List<ClothBean>  getAllClothesProducts(); 
	//更新商品
	void updateClothStock(int clothId, int newQuantity);
	//看全部衣服類別
	List<ClothCategoryBean>  getAllClothCategories();
	//用分類找衣服
	List<ClothBean>  getClothesProductsByCategory(String clothCategory);
	//
	public ClothBean getClothProductById(int clothProductId);
	//新增產品
	void  addClothProduct(ClothBean clothProduct);
	//抓衣服種類
	ClothCategoryBean  getClothCategoryById(int clothCategoryId);
	
	//看所有類
	List<ClothCategoryBean>  getClothCategoryList();
	
	///////////////////////////////////////////////////////
	// 依id來刪除單筆記錄 bookId
	void deleteById(int id);
	// 依id來查詢單筆記錄 bookId
	ClothBean findById(int id);
	////////////////////////////////////////////////////////
//	Map<Integer, ClothBean> getPageClothes(int pageNo);
	////////////////////////////////////////////////////////
	Map<Integer, ClothBean> getPageClothes();

	long getRecordCounts();

	int getTotalPages();
	
	String getAllClothCategoriesTag(String selected);
	
	// 新增一筆記錄
	void save(ClothBean bean);
	
	void updateCloth(ClothBean bean, long sizeInBytes);
	

}
