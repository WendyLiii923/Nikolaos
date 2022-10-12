//package com.java18.nikolaos.ShoppingCart.controller;
package com.java18.nikolaos.listColth.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.java18.nikolaos.listColth.model.ClothCategoryBean;
import com.java18.nikolaos.listColth.model.service.ClothCategoryService;

@RestController
@RequestMapping("/ClothCategoryService")
public class ClothCategoryController {

	@Autowired
	private ClothCategoryService clothCategoryService;

	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
	public ClothCategoryBean createClothCategory(String category, Integer parentId) {
		return clothCategoryService.createClothCategory(category, parentId);
	}

	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<ClothCategoryBean> getClothCategoryList() {
		return clothCategoryService.getClothCategoryList();
	}

	@GetMapping(path = "{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public ClothCategoryBean getCategoryByIdList(@PathVariable("id") Integer id) {
		return clothCategoryService.getClothCategoryById(id);
	}

	@DeleteMapping
	public HashMap<String, String> deleteClothCategory(Integer id) {
		return clothCategoryService.deleteClothCategory(id);
	}

	@PutMapping
	public ClothCategoryBean updateClothCategory(ClothCategoryBean clothCategoryBean) {
		return clothCategoryService.updateClothCategory(clothCategoryBean);
	}
}
