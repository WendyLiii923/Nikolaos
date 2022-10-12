package com.java18.nikolaos.listColth.model.dao;

import java.util.HashMap;
import java.util.List;

import com.java18.nikolaos.listColth.model.ClothCategoryBean;

public interface ClothCategoryDao {
	
	
	//create function
	public ClothCategoryBean createClothCategory(String category,Integer parentId);
	
	
	//read function
	public List<ClothCategoryBean>getClothCategoryList();
	
	public ClothCategoryBean getClothCategoryById(Integer id);
	public ClothCategoryBean getClothCategoryByParentId(Integer parentId);
	
	//delete
	public HashMap<String, String> deleteClothCategory(Integer id);
	
	
	//update
	public ClothCategoryBean updateClothCategory(ClothCategoryBean clothCategoryBean);
	
	/////////////////////////////////////////////////////////////////////////
	
	List<ClothCategoryBean> findAll();
	
	ClothCategoryBean findById(Integer id);
	
	
}
