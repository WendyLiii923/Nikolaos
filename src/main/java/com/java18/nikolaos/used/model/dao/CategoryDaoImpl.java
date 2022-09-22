package com.java18.nikolaos.used.model.dao;

import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java18.nikolaos.used.model.UsedCategory;

@Repository
public class CategoryDaoImpl implements CategoryDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private String selectAllCategory = "FROM com.java18.nikolaos.used.model.UsedCategory";
	private String selectCategoryById = "FROM com.java18.nikolaos.used.model.UsedCategory WHERE ID=:CATEGORYID";
	private String selectCategoryByParentId = "FROM com.java18.nikolaos.used.model.UsedCategory WHERE ID=:parentId";
	
	public CategoryDaoImpl() {

	}

	public Session getSession() {
		Session session = sessionFactory.getCurrentSession();
		return session;
	}

	@Override
	public UsedCategory createCategory(String name, Integer parentId) {
		UsedCategory usedCategory = new UsedCategory();
		try {
			usedCategory.setName(name);
			usedCategory.setParentId(parentId);
			getSession().save(usedCategory);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return usedCategory;
	}

	@Override
	public List<UsedCategory> getCategoryList() {
		Query<UsedCategory> check = getSession().createQuery(selectAllCategory, UsedCategory.class);
		List<UsedCategory> list = check.list();
		return list;
	}
	
	@Override
	public UsedCategory getCategoryById(Integer id) {
		Query<UsedCategory> check = getSession().createQuery(selectCategoryById, UsedCategory.class);
		check.setParameter("CATEGORYID", id);
		UsedCategory aCategory = check.setMaxResults(1)
								 .getResultList()
								 .stream()
								 .findFirst()
								 .orElse(null);
		return aCategory;
	}

	@Override
	public UsedCategory getCategoryByParentId(Integer parentId) {
		Query<UsedCategory> check = getSession().createQuery(selectCategoryByParentId, UsedCategory.class);
		check.setParameter("parentId", parentId);
		UsedCategory aCategory = check.setMaxResults(1)
								 .getResultList()
								 .stream()
								 .findFirst()
								 .orElse(null);
		return aCategory;
	}
	
	@Override
	public HashMap<String, String> deleteCategory(Integer id) {
		HashMap<String, String> status = new HashMap<String, String>();
		try {
			Query<UsedCategory> result = getSession().createQuery(selectCategoryById, UsedCategory.class);
			result.setParameter("CATEGORYID", id);
			List<UsedCategory> list = result.list();
			if (list.isEmpty() == false) {
				UsedCategory deleteItem = list.get(0);
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
	public UsedCategory updateCategory(UsedCategory usedCategory) {
		try {
			Query<UsedCategory> find = getSession().createQuery(selectCategoryById, UsedCategory.class);
			find.setParameter("CATEGORYID", usedCategory.getId());
			List<UsedCategory> list = find.list();
			UsedCategory updateItem = list.get(0);
			updateItem.setName(usedCategory.getName());
			getSession().save(updateItem);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return usedCategory;
	}



}
