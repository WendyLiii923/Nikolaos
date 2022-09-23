package com.java18.nikolaos.used.model.dao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.java18.nikolaos.used.model.dao.util.BaseQuery;
import org.hibernate.query.Query;
import org.springframework.stereotype.Repository;

import com.java18.nikolaos.used.model.Members;
import com.java18.nikolaos.used.model.UsedCategory;
import com.java18.nikolaos.used.model.UsedProduct;

@Repository
public class ProductDaoImpl extends BaseQuery<UsedProduct>  implements ProductDao {

	private String selectProductById = "FROM com.java18.nikolaos.used.model.UsedProduct WHERE ID=:PRODUCTID";
	private String selectAllProduct = "FROM com.java18.nikolaos.used.model.UsedProduct";
	private String selectProductByParentId = "Select p From com.java18.nikolaos.used.model.UsedProduct p LEFT JOIN p.category c WHERE c.parentId = :categoryId";
	private String selectProductByQuery = "Select p FROM com.java18.nikolaos.used.model.UsedProduct p LEFT JOIN p.category c";

	@Override
	public UsedProduct createProduct(String name, Integer price, String content, Members memberId, UsedCategory categoryId) {
		UsedProduct usedProduct = new UsedProduct();
		try {
			usedProduct.setName(name);
			usedProduct.setPrice(price);
			usedProduct.setContent(content);
			usedProduct.setMember(memberId);
			usedProduct.setCategory(categoryId);
			getSession().save(usedProduct);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return usedProduct;
	}

	@Override
	public UsedProduct getProduct(Integer id) {
		Query<UsedProduct> query = getSession().createQuery(selectProductById, UsedProduct.class);
		query.setParameter("PRODUCTID", id);
		return getOne(query);
	}

	@Override
	public List<UsedProduct> getProductList() {
		Query<UsedProduct> query = getSession().createQuery(selectAllProduct, UsedProduct.class);
		return query.getResultList();
	}

	@Override
	public List<UsedProduct> getProductListByParentId(Integer categoryId) {
		Query<UsedProduct> query = getSession().createQuery(selectProductByParentId, UsedProduct.class);
		query.setParameter("categoryId", categoryId);
		return query.getResultList();
	}

	@Override
	public List<UsedProduct> getProductListByQuery(Integer categoryId, Integer start, Integer end,
			String sortField, String sort) {
		String sql = selectProductByQuery;
		List<String> querySqlList = new ArrayList<>();
		Map<String, Object> queryMap = new HashMap<>();
		String order = "";
//		System.out.println("Controller傳過來的:"productId + categoryId + parentId +start + end + status);

		if (categoryId != null) {
			querySqlList.add("c.id=:categoryId");
			queryMap.put("categoryId", categoryId);
		}
		if (start != null && end != null) {
			querySqlList.add("p.price BETWEEN :start AND :end");
			queryMap.put("start", start);
			queryMap.put("end", end);
		}
		if (sort != null && sortField != null) {
			order = "ORDER BY " + sortField + " " + sort;
		}

		if (!querySqlList.isEmpty()) {
			sql = sql + " WHERE " + String.join(" AND ", querySqlList);
			System.out.println(sql);
		}

		if (!"".equals(order)) {
			sql = sql + " " + order;
		}

		Query<UsedProduct> query = getSession().createQuery(sql, UsedProduct.class);
		queryMap.forEach((key, value) -> {
			query.setParameter(key, value);
		});
		return query.getResultList();
	}

	@Override
	public HashMap<String, String> deleteProduct(Integer id) {
		HashMap<String, String> status = new HashMap<String, String>();
		try {
			Query<UsedProduct> result = getSession().createQuery(selectProductById, UsedProduct.class);
			result.setParameter("PRODUCTID", id);
			List<UsedProduct> list = result.list();
			if (list.isEmpty() == false) {
				UsedProduct deleteItem = list.get(0);
				getSession().delete(deleteItem);
			} else {
				status.put("status", "fail to find");
				System.out.println(status);
			}
		} catch (Exception e) {
			e.printStackTrace();
			status.put("status", "fail");
			System.out.println(status);
		}
		status.put("status", "success");
		System.out.println(status);
		return status;
	}

	@Override
	public UsedProduct updateProduct(UsedProduct usedProduct) {
		try {
			Query<UsedProduct> find = getSession().createQuery(selectProductById, UsedProduct.class);
			find.setParameter("PRODUCTID", usedProduct.getId());
			List<UsedProduct> list = find.list();
			UsedProduct updateItem = list.get(0);
			updateItem.setPrice(usedProduct.getPrice());
			getSession().save(updateItem);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return usedProduct;
	}

}
