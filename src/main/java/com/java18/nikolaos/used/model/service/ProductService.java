package com.java18.nikolaos.used.model.service;

import java.util.HashMap;
import java.util.List;

import com.java18.nikolaos.used.model.ProductInfoView;
import com.java18.nikolaos.used.model.UsedProduct;

public interface ProductService {

	UsedProduct createProduct(String name, Integer price, String content, Integer memberId, Integer categoryId,
			String cover, String status);

	ProductInfoView getProductInfo(Integer id);
	
	List<UsedProduct> getProductListByMemberId(Integer memberId);

	List<ProductInfoView> getProductsByParentId(Integer categoryId);

	List<ProductInfoView> getProducts(Integer categoryId, Integer parentId, Integer start, Integer end, String status);

	UsedProduct getProduct(Integer id);
	
	HashMap<String, String> deleteProduct(Integer id);

	UsedProduct updateProduct(UsedProduct usedProduct);

}