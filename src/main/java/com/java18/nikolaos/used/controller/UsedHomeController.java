package com.java18.nikolaos.used.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.java18.nikolaos.used.model.service.CategoryService;
import com.java18.nikolaos.used.model.service.ProductService;

@Controller
@RequestMapping("/used")
public class UsedHomeController {
	
	@Autowired
	private CategoryService categoryService;
	@Autowired
	private ProductService productService;
	
	@RequestMapping
	public String list(Model model, 
			@RequestParam(required = false) Integer categoryId, 
			@RequestParam(required = false) Integer parentId,
            @RequestParam(required = false) Integer start, 
            @RequestParam(required = false) Integer end, 
            @RequestParam(defaultValue = "") String status) {
		model.addAttribute("productList", productService.getProducts(categoryId, parentId, start, end, status));
		model.addAttribute("category", categoryService.getCategoryById(categoryId));
		model.addAttribute("categoryList", categoryService.getCategoryList());
		return "/used/usedHome";
	}

}
