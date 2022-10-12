package com.java18.nikolaos.listColth.model.dao.impl;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java18.nikolaos.listColth.model.ClothCategoryBean;
import com.java18.nikolaos.listColth.model.dao.ClothCategoryDao;





@Repository
public class ClothCategoryDaoImpl implements Serializable ,ClothCategoryDao{
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Autowired
	SessionFactory factory;
	
	private String selectAllClothCategory = 
			"FROM com.java18.nikolaos.listColth.model.ClothCategoryBean";
	private String selectClothCategoryById = 
			"FROM com.java18.nikolaos.listColth.model.ClothCategoryBean WHERE ID=:clothCategoryId";
	private String selectClothCategoryByParentId = 
			"FROM com.java18.nikolaos.listColth.model.ClothCategoryBean WHERE ID=:parentId";
	
//	private String selectAllCategory = "FROM com.java18.nikolaos.used.model.UsedCategory";
//	private String selectCategoryById = "FROM com.java18.nikolaos.used.model.UsedCategory WHERE ID=:CATEGORYID";
//	private String selectCategoryByParentId = "FROM com.java18.nikolaos.used.model.UsedCategory WHERE ID=:parentId";
	
	
	public ClothCategoryDaoImpl() {
		
	}
	public Session getSession() {
		Session session = factory.getCurrentSession();
		return session;
	}
	
	
	public ClothCategoryDaoImpl(SessionFactory factory) {
		this.factory = factory;
	}
	
	
	@Override
	public ClothCategoryBean createClothCategory(String category, Integer parentId) {
		ClothCategoryBean clothCategoryBean =new ClothCategoryBean();
		try {
			clothCategoryBean.setCategory(category);
			clothCategoryBean.setParentId(parentId);
			getSession().save(clothCategoryBean);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return clothCategoryBean;
	}
	


	@Override
	public List<ClothCategoryBean> getClothCategoryList() {
		Query<ClothCategoryBean> check = getSession()
				.createQuery(selectAllClothCategory, ClothCategoryBean.class);
		List<ClothCategoryBean> list = check.list();
		return list;
	}

	@Override
	public ClothCategoryBean getClothCategoryById(Integer id) {
		Query<ClothCategoryBean> check = getSession()
				.createQuery(selectClothCategoryById, ClothCategoryBean.class);
		check.setParameter("clothCategoryId", id);
		ClothCategoryBean cCategory = check.setMaxResults(1)
								 .getResultList()
								 .stream()
								 .findFirst()
								 .orElse(null);
		return cCategory;
	}

	@Override
	public ClothCategoryBean getClothCategoryByParentId(Integer parentId) {
		Query<ClothCategoryBean> check = getSession()
				.createQuery(selectClothCategoryByParentId, ClothCategoryBean.class);
		check.setParameter("parentId", parentId);
		ClothCategoryBean cCategory = check.setMaxResults(1)
								 .getResultList()
								 .stream()
								 .findFirst()
								 .orElse(null);
		return cCategory;
	}

	@Override
	public HashMap<String, String> deleteClothCategory(Integer id) {
		HashMap<String, String> status = new HashMap<String, String>();
		try {
			Query<ClothCategoryBean> result = getSession()
					.createQuery(selectClothCategoryById, ClothCategoryBean.class);
			result.setParameter("clothCategoryId", id);
			List<ClothCategoryBean> list = result.list();
			if (list.isEmpty() == false) {
				ClothCategoryBean deleteItem = list.get(0);
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
	public ClothCategoryBean updateClothCategory(ClothCategoryBean clothCategoryBean) {
		try {
			Query<ClothCategoryBean> find = getSession()
					.createQuery(selectClothCategoryById, ClothCategoryBean.class);
			find.setParameter("clothCategoryId",clothCategoryBean.getId());
			List<ClothCategoryBean> list = find.list();
			ClothCategoryBean updateItem = list.get(0);
			updateItem.setCategory(clothCategoryBean.getCategory());
			getSession().save(updateItem);
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	//////////////////////////////////////////////////////////////
	@Override
	public List<ClothCategoryBean> findAll() {
		List<ClothCategoryBean> list = new ArrayList<>();
		String hql = "FROM ClothCategoryBean";
		
		Session session = factory.getCurrentSession();
		
		list = session.createQuery(hql, ClothCategoryBean.class)
				      .getResultList();
		
//		log.info("新增與更新書籍之前置作業之Dao#findAll(), List<CompanyBean>=" + list); 
		return list;
		
		
		
		
	}
	@Override
	public ClothCategoryBean findById(Integer id) {
		Session session = factory.getCurrentSession();
		ClothCategoryBean clothCategoryBean = session.get(ClothCategoryBean.class, id);
//		log.info("CompanyDaoImpl_Hibernate#findById(), CompanyBean=" + companyBean);
		return clothCategoryBean;
	}

	
	


	
}
