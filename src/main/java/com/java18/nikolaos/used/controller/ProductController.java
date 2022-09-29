package com.java18.nikolaos.used.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.java18.nikolaos.used.model.UsedProduct;
import com.java18.nikolaos.used.model.service.CategoryService;
import com.java18.nikolaos.used.model.service.ProductService;

@Controller
@RequestMapping("/ProductService")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	@Autowired
	private CategoryService categoryService;
	
	@RequestMapping("/showMemberProducts")
	public String manageProducts(Model model,
			@RequestParam(required = false) Integer memberId,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) Integer price,
			@RequestParam(required = false) String content,
			@RequestParam(required = false) Integer categoryId,
			@RequestParam(required = false) String cover,
			@RequestParam(required = false) String status
			) {
		model.addAttribute("productList", productService.getProductListByMemberId(memberId));
		model.addAttribute("product", productService.createProduct(name, price, content, memberId, categoryId, cover, status));
		model.addAttribute("categoryList", categoryService.getCategoryList());
		return "/used/MemberProducts";
	}
	
	@RequestMapping("/showUploadForm")
	public String newProduct(Model model
			) {
		model.addAttribute("categoryList", categoryService.getCategoryList());
		return "/used/ProductLaunch";
	}
	
	@RequestMapping("/showProducts")
	public String list(Model model, 
			@RequestParam(required = false) Integer productId,
			@RequestParam(required = false) Integer categoryId, 
			@RequestParam(required = false) Integer parentId,
            @RequestParam(required = false) Integer start, 
            @RequestParam(required = false) Integer end, 
            @RequestParam(defaultValue = "") String status) {
		model.addAttribute("productList", productService.getProducts(categoryId, parentId, start, end, status));
		model.addAttribute("category", categoryService.getCategoryById(categoryId));
		model.addAttribute("categoryList", categoryService.getCategoryList());
		return "/used/Category";
	}
	
	@RequestMapping("/showProduct")
	public String product(Model model, 
			@RequestParam(required = false) Integer categoryId, 
			@RequestParam(required = false) Integer productId,
			@RequestParam(required = false) Integer parentId,
            @RequestParam(required = false) Integer start, 
            @RequestParam(required = false) Integer end, 
            @RequestParam(defaultValue = "") String status) {
		UsedProduct getProduct = productService.getProduct(productId);
		model.addAttribute("product", getProduct);
		model.addAttribute("parentCategory", categoryService.getCategoryByParentId(getProduct.getCategory().getParentId()));
		model.addAttribute("productList", productService.getProducts(categoryId, parentId, start, end, status));
		model.addAttribute("categoryList", categoryService.getCategoryList());
		return "/used/Product";
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<UsedProduct> getProducts(@RequestParam(required = false) Integer categoryId,
  										 @RequestParam(required = false) Integer parentId,
			                             @RequestParam(required = false) Integer start, 
			                             @RequestParam(required = false) Integer end, 
			                             @RequestParam(required = false) String status) {
		
		return productService.getProducts(categoryId, parentId, start, end, status);
	}
	
//	@PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
//	@PostMapping
//	@ResponseBody
//	public UsedProduct createProduct(@RequestBody UsedProduct body) {
//		return productService.createProduct(body.getName(),body.getPrice(), body.getContent(), body.getMember(), body.getCategory(), body.getCover(), body.getStatus());
//	}
	
	@DeleteMapping
	@ResponseBody
	public HashMap<String, String> deleteProduct(@RequestParam Integer id) {
		return productService.deleteProduct(id);
	}
	
	@PutMapping
	@ResponseBody
	public UsedProduct updateProduct(@RequestBody UsedProduct body) {
		return productService.updateProduct(body);
	}
	

}
