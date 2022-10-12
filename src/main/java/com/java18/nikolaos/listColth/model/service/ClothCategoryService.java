package com.java18.nikolaos.listColth.model.service;

import java.util.HashMap;
import java.util.List;

import com.java18.nikolaos.listColth.model.ClothCategoryBean;


public interface ClothCategoryService {
	

	public ClothCategoryBean createClothCategory(String category, Integer parentId);
	
	public List<ClothCategoryBean> getClothCategoryList();
	
	public ClothCategoryBean getClothCategoryById(Integer id);
	
	public ClothCategoryBean getClothCategoryByParentId(Integer parentId);
	
	public HashMap<String, String> deleteClothCategory(Integer id);
	
	public ClothCategoryBean updateClothCategory(ClothCategoryBean clothCategoryBean);
	
	
	////////////////////////////////////////////////////////////////
	
	ClothCategoryBean findById(Integer id);

	List<ClothCategoryBean>findAll();
	
	
}
