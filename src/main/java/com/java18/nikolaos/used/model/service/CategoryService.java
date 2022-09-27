package com.java18.nikolaos.used.model.service;

import java.util.HashMap;
import java.util.List;

import com.java18.nikolaos.used.model.UsedCategory;

public interface CategoryService {

	UsedCategory createCategory(String name, Integer parentId);

	List<UsedCategory> getCategoryList();

	UsedCategory getCategoryById(Integer id);

	UsedCategory getCategoryByParentId(Integer parentId);

	HashMap<String, String> deleteCategory(Integer id);

	UsedCategory updateCategory(UsedCategory usedCategory);

}