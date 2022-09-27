package com.java18.nikolaos.used.model.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java18.nikolaos.used.model.Members;
import com.java18.nikolaos.used.model.UsedCategory;
import com.java18.nikolaos.used.model.UsedProduct;
import com.java18.nikolaos.used.model.dao.ProductDao;
import com.java18.nikolaos.used.model.service.ProductService;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductDao productDao;

	/**
	 *  商品狀態
	 *  暫存 - temp
	 *  發布 - published
	 *  刪除 - delete
	 *  下架 - archive
	 */
	public static final String PRODUCT_STATUS_TEMP = "temp";
	public static final String PRODUCT_STATUS_PUBLISHED = "published";
	public static final String PRODUCT_STATUS_DELETE = "delete";
	public static final String PRODUCT_STATUS_ARCHIVE = "archive";

	@Override
	public UsedProduct createProduct(String name, Integer price, String content, Members memberId, UsedCategory categoryId, String cover, String status) {
		return productDao.createProduct(name, price, content, memberId, categoryId, cover, status);
	}

	@Override
	public UsedProduct getProduct(Integer id) {
		return productDao.getProduct(id);
	}
	
	@Override
	public List<UsedProduct> getProductsByParentId(Integer categoryId) {
		return productDao.getProductListByParentId(categoryId);
	}

	@Override
	public List<UsedProduct> getProducts(Integer categoryId, Integer parentId, Integer start, Integer end, String status) {
		String sortField1 = "p.price";
		String sortField2 = "p.createTime";
		String sort1 = "ASC";
		String sort2 = "DESC";

		if (categoryId != null && parentId != null) {
//			如果為子分類
			switch (status) {
			case "低到高":
				return productDao.getProductListByQuery(categoryId, start, end, sortField1, sort1);
			case "高到低":
				return productDao.getProductListByQuery(categoryId, start, end, sortField1, sort2);
			case "新到舊":
				return productDao.getProductListByQuery(categoryId, start, end, sortField2, sort2);
			case "舊到新":
				return productDao.getProductListByQuery(categoryId, start, end, sortField2, sort1);
			case "價格區間":
				return productDao.getProductListByQuery(categoryId, start, end, null, null);
			default:
				return productDao.getProductListByQuery(categoryId, start, end, null, null);
			}
		}else if (categoryId != null && parentId == null) {
//			如果為父分類
			return productDao.getProductListByParentId(categoryId);
		}else {
			switch (status) {
			case "低到高":
				return productDao.getProductListByQuery(categoryId, start, end, sortField1, sort1);
			case "高到低":
				return productDao.getProductListByQuery(categoryId, start, end, sortField1, sort2);
			case "新到舊":
				return productDao.getProductListByQuery(categoryId, start, end, sortField2, sort2);
			case "舊到新":
				return productDao.getProductListByQuery(categoryId, start, end, sortField2, sort1);
			case "價格區間":
				return productDao.getProductListByQuery(categoryId, start, end, null, null);
			default:
				return productDao.getProductList();
			}
		}
	}

	@Override
	public HashMap<String, String> deleteProduct(Integer id) {
		return productDao.deleteProduct(id);
	}

	@Override
	public UsedProduct updateProduct(UsedProduct usedProduct) {
		return productDao.updateProduct(usedProduct);
	}

}
