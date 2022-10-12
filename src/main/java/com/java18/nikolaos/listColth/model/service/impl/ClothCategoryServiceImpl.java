package com.java18.nikolaos.listColth.model.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java18.nikolaos.listColth.model.ClothCategoryBean;
import com.java18.nikolaos.listColth.model.dao.ClothCategoryDao;
import com.java18.nikolaos.listColth.model.service.ClothCategoryService;

@Service
@Transactional
public class ClothCategoryServiceImpl implements ClothCategoryService{
	
	@Autowired
	ClothCategoryDao clothCategoryDao;

	public ClothCategoryServiceImpl(ClothCategoryDao clothCategoryDao) {
		this.clothCategoryDao = clothCategoryDao;
	}

	@Override
	public ClothCategoryBean createClothCategory(String category, Integer parentId) {
		return clothCategoryDao.createClothCategory(category, parentId);
	}

	@Override
	public List<ClothCategoryBean> getClothCategoryList() {
		return clothCategoryDao.getClothCategoryList();
	}

	@Override
	public ClothCategoryBean getClothCategoryById(Integer id) {
		return clothCategoryDao.getClothCategoryById(id);
	}

	@Override
	public ClothCategoryBean getClothCategoryByParentId(Integer parentId) {
		
		return clothCategoryDao.getClothCategoryByParentId(parentId);
	}

	@Override
	public HashMap<String, String> deleteClothCategory(Integer id) {
		
		return clothCategoryDao.deleteClothCategory(id);
	}

	@Override
	public ClothCategoryBean updateClothCategory(ClothCategoryBean clothCategoryBean) {
		
		return clothCategoryDao.updateClothCategory(clothCategoryBean);
	}

	@Override
	public ClothCategoryBean findById(Integer id) {
		ClothCategoryBean clothCategoryBean = null;
		clothCategoryBean = clothCategoryDao.findById(id);
		return clothCategoryBean;
	}

	@Override
	public List<ClothCategoryBean> findAll() {
		List<ClothCategoryBean> clothCategoryBeans = null;
		clothCategoryBeans = clothCategoryDao.findAll();
		return clothCategoryBeans;
	}
}
