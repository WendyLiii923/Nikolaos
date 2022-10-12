package com.java18.nikolaos.ShoppingCart.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.java18.nikolaos.listColth.model.ClothBean;
import com.java18.nikolaos.listColth.model.service.ClothService;



@Controller("ProductController_Cloth")
public class ProductController {

	ClothService clothService;
	
	
	@Autowired
	public ProductController(ClothService clothService) {
		this.clothService = clothService;
	}

	@GetMapping("/products")
	public String list(Model model) {
		List<ClothBean> list = clothService.getAllClothesProducts();
		model.addAttribute("products", list);//修改 products
		return "products";
	}
	
//	@GetMapping("/update/stock")
	public String updateAllStocks(Model model) {
		clothService.updateAllStocks();
	    return "redirect:/products";
	}   
	
//	@GetMapping("/queryByCategory")
	public String getAllClothCategoryList(Model model) {
//	    List<String>  list = clothService.getAllClothCategories();
//	    model.addAttribute("categoryList", list);//修改 categoryList
	    return "types/category";
	}

//	@GetMapping("/products/{category}")
	public String getClothesProductsByCategory(
			@PathVariable("category") String category,  //修改category
			Model model
	){
	    List<ClothBean> products = clothService.getClothesProductsByCategory(category);
	    model.addAttribute("products", products); //修改products
	    return "products";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}
