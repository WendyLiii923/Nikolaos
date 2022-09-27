package com.java18.nikolaos.used.model.service.impl;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java18.nikolaos.used.model.UsedCategory;
import com.java18.nikolaos.used.model.dao.CategoryDao;
import com.java18.nikolaos.used.model.service.CategoryService;

@Service
@Transactional
public class CategoryServiceImpl implements CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	@Override
	public UsedCategory createCategory(String name, Integer parentId) {
		return categoryDao.createCategory(name, parentId);
	}
	
	@Override
	public List<UsedCategory> getCategoryList() {
		return categoryDao.getCategoryList();
	}
	
	@Override
	public UsedCategory getCategoryById(Integer id) {
		return categoryDao.getCategoryById(id);
	}
	
	@Override
	public UsedCategory getCategoryByParentId(Integer parentId) {
		return categoryDao.getCategoryByParentId(parentId);
	}
	
	@Override
	public HashMap<String, String> deleteCategory(Integer id) {
		return categoryDao.deleteCategory(id);
	}
	
	@Override
	public UsedCategory updateCategory(UsedCategory usedCategory) {
		return categoryDao.updateCategory(usedCategory);
	}

}
