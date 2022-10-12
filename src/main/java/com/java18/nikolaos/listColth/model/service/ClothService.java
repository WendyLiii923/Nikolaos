package com.java18.nikolaos.listColth.model.service;

import java.util.List;
import java.util.Map;

import com.java18.nikolaos.listColth.model.ClothBean;
import com.java18.nikolaos.listColth.model.ClothCategoryBean;

public interface ClothService {
	
	List<ClothBean>  getAllClothesProducts();
	//購物車內數量
	void updateAllStocks();
	
	List<ClothCategoryBean>  getAllClothCategories();

	List<ClothBean>  getClothesProductsByCategory(String clothCategory);
	
	public ClothBean getClothProductById(int clothId);
	
	void  addClothProduct(ClothBean cloth);
	
	ClothCategoryBean  getClothCategoryById(int clothCategoryId);
	
	List<ClothCategoryBean>  getClothCategoryList();
	////////////////////////////////////////////////////////////////////////
	
	
	// 依照頁碼來讀取一頁的商品資料
//	Map<Integer, ClothBean> getPageClothes(int pageNo);
	Map<Integer, ClothBean> getPageClothes();
	// 讀取的商品總頁數
	int getTotalPages();
	
	// 更新商品資料
		void updateCloth(ClothBean bean, long sizeInBytes) ;
		
		List<ClothBean>findAllCategories();
	
		// 依id    bookId來刪除單筆記錄
		void deleteById(int id);
		
		void save(ClothBean bean);
		
		// 依id   bookId來查詢單筆記錄
		ClothBean findById(int id);
	
	
	
	

}
