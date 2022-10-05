package com.java18.nikolaos.used.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.java18.nikolaos.general.model.service.ImageService;
import com.java18.nikolaos.used.model.ProductInfoView;
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
	@Autowired
	private ImageService imageService;
	
	@RequestMapping("/updateProduct")
	public String updateProduct(Model model,
			@RequestParam(required = false) Integer memberId,
			@RequestParam(required = false) Integer productId,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) Integer price,
			@RequestParam(required = false) String content,
			@RequestParam(required = false) Integer categoryId,
			@RequestParam(required = false) MultipartFile cover
			) {
		UsedProduct usedProduct = productService.getProduct(productId);
		usedProduct.setId(productId);
		usedProduct.setName(name);
		usedProduct.setPrice(price);
		usedProduct.setContent(content);
		usedProduct.setCategoryId(categoryId);

		if (cover != null && !cover.isEmpty()) {
			String coverLink = imageService.upload(cover);
			usedProduct.setCover(coverLink);
		}

		model.addAttribute("product", productService.updateProduct(usedProduct));
		model.addAttribute("productInfo", productService.getProductInfo(productId));
		model.addAttribute("productList", productService.getProductListByMemberId(memberId));
		model.addAttribute("categoryList", categoryService.getCategoryList());
		return "/used/MemberProducts";
	}
	
	@RequestMapping("/showUpdateForm")
	public String newProduct(Model model,
			@RequestParam(required = false) Integer productId
			
			) {
		model.addAttribute("productInfo", productService.getProductInfo(productId));
		model.addAttribute("categoryList", categoryService.getCategoryList());
		return "/used/ProductUpdate";
	}
	
	@RequestMapping("/deleteProduct")
	public String deleteProduct(Model model,
			@RequestParam(required = false) Integer memberId,
			@RequestParam(required = false) Integer productId
			) {
		model.addAttribute("product", productService.deleteProduct(productId));
		model.addAttribute("productList", productService.getProductListByMemberId(memberId));
		model.addAttribute("categoryList", categoryService.getCategoryList());
		return "/used/MemberProducts";
	}
	
	@RequestMapping("/showMemberProducts")
	public String manageProducts(Model model,
			@RequestParam(required = false) Integer memberId
			) {
		model.addAttribute("productList", productService.getProductListByMemberId(memberId));
		model.addAttribute("categoryList", categoryService.getCategoryList());
		return "/used/MemberProducts";
	}
	
	@RequestMapping("/uploadForm")
	public String uploadProduct(Model model,
			@RequestParam(required = false) String name,
			@RequestParam(required = false) Integer price,
			@RequestParam(required = false) String content,
			@RequestParam(required = false) Integer memberId,
			@RequestParam(required = false) Integer categoryId,
			@RequestParam(required = false) MultipartFile cover,
			@RequestParam(required = false) String status
			) {
		String coverLink = imageService.upload(cover);
		model.addAttribute("product", productService.createProduct(name, price, content, memberId, categoryId, coverLink, status));
		model.addAttribute("categoryList", categoryService.getCategoryList());
		return "/used/MemberProducts";
	}
	
	@RequestMapping("/showUploadForm")
	public String newProduct(Model model
			) {
		model.addAttribute("categoryList", categoryService.getCategoryList());
		return "/used/ProductLaunch";
	}
	
//	@RequestMapping("/showProducts")
//	public String list(Model model, 
//			@RequestParam(required = false) Integer categoryId, 
//			@RequestParam(required = false) Integer parentId,
//            @RequestParam(required = false) Integer start, 
//            @RequestParam(required = false) Integer end, 
//            @RequestParam(defaultValue = "") String status) {
//		model.addAttribute("productList", productService.getProducts(categoryId, parentId, start, end, status));
//		model.addAttribute("category", categoryService.getCategoryById(categoryId));
//		model.addAttribute("categoryList", categoryService.getCategoryList());
//		return "/used/Category";
//	}
	
	@RequestMapping("/showProduct")
	public String product(Model model, 
			@RequestParam(required = false) Integer productId,
			@RequestParam(required = false) Integer categoryId, 
			@RequestParam(required = false) Integer parentId,
            @RequestParam(required = false) Integer start, 
            @RequestParam(required = false) Integer end, 
            @RequestParam(defaultValue = "") String status) {
		ProductInfoView getProduct = productService.getProductInfo(productId);
		model.addAttribute("product", getProduct);
		model.addAttribute("parentCategory", categoryService.getCategoryByParentId(getProduct.getParentId()));
		model.addAttribute("productList", productService.getProducts(categoryId, parentId, start, end, status));
		model.addAttribute("categoryList", categoryService.getCategoryList());
		return "/used/Product";
	}
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public List<ProductInfoView> getProducts(@RequestParam(required = false) Integer categoryId,
  										 @RequestParam(required = false) Integer parentId,
			                             @RequestParam(required = false) Integer start, 
			                             @RequestParam(required = false) Integer end, 
			                             @RequestParam(required = false) String status) {
		
		return productService.getProducts(categoryId, parentId, start, end, status);
	}
	
	@DeleteMapping
	@ResponseBody
	public HashMap<String, String> deleteProduct(@RequestParam Integer id) {
		return productService.deleteProduct(id);
	}
	
}
