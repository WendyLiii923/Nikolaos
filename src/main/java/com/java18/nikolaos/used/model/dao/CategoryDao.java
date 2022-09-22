package com.java18.nikolaos.used.model.dao;

import java.util.HashMap;
import java.util.List;

import com.java18.nikolaos.used.model.UsedCategory;

public interface CategoryDao {
	
	//create function
	public UsedCategory createCategory(String name, Integer parentId);

	//read function
	public List<UsedCategory> getCategoryList();
	public UsedCategory getCategoryById(Integer id);
	public UsedCategory getCategoryByParentId(Integer parentId);
	
	//delete
	public HashMap<String, String> deleteCategory(Integer id);
	
	//update
	public UsedCategory updateCategory(UsedCategory usedCategory);
	
	

}
