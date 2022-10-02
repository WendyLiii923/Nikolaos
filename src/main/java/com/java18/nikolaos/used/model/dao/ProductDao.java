package com.java18.nikolaos.used.model.dao;

import java.util.HashMap;
import java.util.List;

import com.java18.nikolaos.used.model.ProductInfoView;
import com.java18.nikolaos.used.model.UsedProduct;

public interface ProductDao {
	// 新增商品
	public UsedProduct createProduct(String name, Integer price, String content, Integer memberId, Integer categoryId, String cover, String status);
	
	// 查會員的二手商品清單
	public List<UsedProduct> getProductListByMemberId(Integer memberId);
	
	// 查單項商品資料
	public ProductInfoView getProduct(Integer id);
	// 查所有商品清單
	public List<ProductInfoView> getProductList();
	// 查父層分類商品清單
	public List<ProductInfoView> getProductListByParentId(Integer parentId);
	// 用分類或排序或價格區間 查詢商品清單
	public List<ProductInfoView> getProductListByQuery(Integer categoryId, Integer start, Integer end, String sortField, String sort);
	
	// 刪除商品
	public HashMap<String, String> deleteProduct(Integer id);
	// 修改商品
	public UsedProduct updateProduct(UsedProduct usedProduct);

}
