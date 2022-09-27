package com.java18.nikolaos.used.model.service;

import java.util.HashMap;
import java.util.List;

import com.java18.nikolaos.used.model.Members;
import com.java18.nikolaos.used.model.UsedCategory;
import com.java18.nikolaos.used.model.UsedProduct;

public interface ProductService {

	UsedProduct createProduct(String name, Integer price, String content, Members memberId, UsedCategory categoryId,
			String cover, String status);

	UsedProduct getProduct(Integer id);

	List<UsedProduct> getProductsByParentId(Integer categoryId);

	List<UsedProduct> getProducts(Integer categoryId, Integer parentId, Integer start, Integer end, String status);

	HashMap<String, String> deleteProduct(Integer id);

	UsedProduct updateProduct(UsedProduct usedProduct);

}