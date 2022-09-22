package com.java18.nikolaos.used.model.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java18.nikolaos.used.model.UsedCategory;
import com.java18.nikolaos.used.model.dao.CategoryDao;

@Service
@Transactional
public class CategoryService {
	
	@Autowired
	private CategoryDao categoryDao;
	
	public UsedCategory createCategory(String name, Integer parentId) {
		return categoryDao.createCategory(name, parentId);
	}
	
	public List<UsedCategory> getCategoryList() {
		return categoryDao.getCategoryList();
	}
	
	public UsedCategory getCategoryById(Integer id) {
		return categoryDao.getCategoryById(id);
	}
	
	public UsedCategory getCategoryByParentId(Integer parentId) {
		return categoryDao.getCategoryByParentId(parentId);
	}
	
	public HashMap<String, String> deleteCategory(Integer id) {
		return categoryDao.deleteCategory(id);
	}
	
	public UsedCategory updateCategory(UsedCategory usedCategory) {
		return categoryDao.updateCategory(usedCategory);
	}

}
