package com.java18.nikolaos.productMaintain.controller;

import java.sql.Blob;
import java.util.List;

import javax.sql.rowset.serial.SerialBlob;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.java18.nikolaos.listColth.model.ClothBean;
import com.java18.nikolaos.listColth.model.ClothCategoryBean;
import com.java18.nikolaos.listColth.model.service.ClothCategoryService;
import com.java18.nikolaos.listColth.model.service.ClothService;
//import com.java18.nikolaos.productMaintain.validator.ClothValidator;

import jakarta.validation.Valid;

//import _03_listBooks.model.CompanyBean;
@Controller
@RequestMapping("/productMaintain")

@SessionAttributes({ "loginMember", "pageNo" })
public class ClothInsertController {

//	private static Logger log = LoggerFactory.getLogger(ClothInsertController.class);

	ClothCategoryService clothCategoryService;

	ClothService clothService;

	@Autowired
	public ClothInsertController(ClothCategoryService clothCategoryService, ClothService clothService) {
//		log.info("建構ClothInsertController物件");
		this.clothCategoryService = clothCategoryService;
		this.clothService = clothService;
	}

	@GetMapping("ClothInsert")
	public String getForm(Model model) {
		 model.addAttribute("clothBean", new ClothBean());
		 model.addAttribute("ClothCategoryList", clothService.getClothCategoryList());
		return "productMaintain/ClothInsert";
		 
	}

//	@GetMapping("ClothUpdate/{id}/{pageNo}")
	@GetMapping("ClothUpdate/{id}")
	public String showUpdateForm(Model model,
			@PathVariable("id") Integer id) {
		model.addAttribute("cothBean",clothService.findById(id));
		model.addAttribute("ClothCategory",clothCategoryService.getClothCategoryList());
		return "productMaintain/ClothUpdate";
	}

//	@PostMapping("ClothUpdate/{id}/{pageNo}")
	@PostMapping("ClothUpdate/{id}")
	public String updateForm(@ModelAttribute ClothBean bean, Model model, BindingResult result,
			RedirectAttributes redirectAttributes) {
		long sizeInBytes = -1;
//		ClothValidator validator = new ClothValidator(false);
//		validator.validate(bean, result);
//		if (result.hasErrors()) {
//			System.out.println("======================");
//			List<ObjectError> list = result.getAllErrors();
//			for (ObjectError error : list) {
//				System.out.println("有錯誤：" + error);
//			}
//			System.out.println("======================");
////			return "productMaintain/BookUpdate";// 修改
//			return "productMaintai/ClothUpdate";
//		}

		if (bean.getProductImage().getSize() == 0) {
//			getProductPhoto //真正取圖片的方法
			sizeInBytes = -1;
		} else {
			sizeInBytes = bean.getProductImage().getSize();
			// Step1
			String imageOriginalFilename = bean.getProductImage().getOriginalFilename();
			bean.setFile_Name(imageOriginalFilename);
			// Step2
			Blob photo = null; //coverImage
			try {
				byte[] b = bean.getProductImage().getBytes();
				photo = new SerialBlob(b);
			} catch (Exception e) {
				e.printStackTrace();
			}
			bean.setPhoto(photo);
		}
		// Step3
		ClothCategoryBean clothCategoryBean = clothCategoryService.findById(bean.getClothCategoryBean().getId());
		bean.setClothCategoryBean(clothCategoryBean);
		clothService.updateCloth(bean, sizeInBytes);
		redirectAttributes.addFlashAttribute("SUCCESS", "修改成功!!!");
		return "redirect:/productMaintain/DisplayPageProducts";
	}

	@GetMapping(value = "/ClothDelete/{id}") /// BookDelete/{bookId}
	public String deleteCloth(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		clothService.deleteById(id); // 修改
		redirectAttributes.addFlashAttribute("SUCCESS", "刪除成功!!!");
		return "redirect:/productMaintain/DisplayPageProducts";
//		return "redirect:/productMaintain/DisplayPageProducts";
	}

	@PostMapping("/ClothInsert")
	public String saveForm(Model model, @Valid ClothBean bean, BindingResult result,
			RedirectAttributes redirectAttributes) {
		System.out.println(bean.getName());
//		ClothValidator validator = new ClothValidator();
//		validator.validate(bean, result);
//		if (result.hasErrors()) {
//			System.out.println("======================");
//			List<ObjectError> list = result.getAllErrors();
//			for (ObjectError error : list) {
//				System.out.println("有錯誤：" + error);
//			}
//			System.out.println("======================");
//			
//			return "productMaintain/ClothInsert";
//			
////			return "productMaintain/ClothInsert";
//		}

		// 存檔前需要執行：
		// 1. 設定fileName屬性
		// 2. 將圖片由 productImage屬性轉換為Blob後存入 coverImage屬性
		// 3. 依照companyBean.id的值讀取 CompanyBean，然後存入 companyBean屬性

		// Step1
		String imageOriginalFilename = bean.getProductImage().getOriginalFilename();
		bean.setFile_Name(imageOriginalFilename);
		// Step2
		Blob photo = null;
		try {
			byte[] b = bean.getProductImage().getBytes();
			photo = new SerialBlob(b);
		} catch (Exception e) {
			e.printStackTrace();
		}
		bean.setPhoto(photo);
		// Step3
		ClothCategoryBean clothCategoryBean = clothCategoryService.findById(bean.getClothCategoryBean().getId());
		bean.setClothCategoryBean(clothCategoryBean);
//		if (bean.getDiscount() == null) {
//			bean.setDiscount(1.0);
//		} //折扣

		if (bean.getStock() == null) {
			bean.setStock(0);
		}
		clothService.save(bean);
		redirectAttributes.addFlashAttribute("SUCCESS", "新增成功!!!");
		
		model.addAttribute("products_DPP", clothService.getPageClothes());
		return "productMaintain/ClothMaintainList";
	}

	@GetMapping(value = "/getAllClothCategories")
	public String getAllClothCategories(Model model) {
		model.addAttribute("ClothCategories", clothService.getAllClothCategories());
		return "productMaintain/productMaintain";
	}

	@ModelAttribute // companyBeanList //clothCategoryBeanList
	public List<ClothCategoryBean> getClothCategory() {
		return clothCategoryService.findAll();
	}

//	@ModelAttribute("category")
	public List<ClothBean> getCategory(Model model) {
		return clothService.findAllCategories();
	}
	@ModelAttribute("clothBean")
	public ClothBean getClothBean(
			@PathVariable(value = "id", required = false) Integer id
			) {
		ClothBean bean = null;
		if(id==null) {
			bean =new ClothBean();
		}else {
			System.out.println("id="+id);
			bean = clothService.findById(id);
		}
		return bean;
	}
	
	
	
}
