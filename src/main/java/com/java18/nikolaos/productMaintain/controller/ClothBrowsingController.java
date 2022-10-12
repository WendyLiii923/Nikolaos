package com.java18.nikolaos.productMaintain.controller;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.java18.nikolaos.listColth.model.ClothBean;
import com.java18.nikolaos.listColth.model.service.ClothService;
import com.java18.nikolaos.register.model.MemberBean;

@Controller
@RequestMapping("/productMaintain")
@SessionAttributes({"products_DPP","loginMember" })//"LoginOK", "pageNo",
public class ClothBrowsingController {
	
//	private static Logger log = LoggerFactory.getLogger(BookBrowsingController.class);

	ClothService clothService;
	
	@Autowired
	public ClothBrowsingController(ClothService clothService) {
		this.clothService = clothService;
	}
	
	
 
	@GetMapping("/DisplayPageProducts")
	public String  displayPageProducts(Model model, 
			HttpServletRequest request, HttpServletResponse response
			) {
		model.addAttribute("coBean", clothService);
		Map<Integer, ClothBean> clothMap = clothService.getPageClothes();
		model.addAttribute("totalPages", clothService.getTotalPages());
		model.addAttribute("products_DPP", clothMap);
		
		MemberBean memberBean = (MemberBean) model.getAttribute("loginMember");
		if (memberBean == null) {
			return "redirect:/login/login";
		}
//		String memberId = memberBean.getMemberId();
//		if (pageNo == null) {
//			pageNo = 1;
//			// 讀取瀏覽器送來的所有 Cookies
//			Cookie[] cookies = request.getCookies();
//			if (cookies != null) {
//				// 逐筆檢視Cookie內的資料
//				for (Cookie c : cookies) {
//					if (c.getName().equals(memberId + "pageNo")) {
//						try {
//							pageNo = Integer.parseInt(c.getValue().trim());
//						} catch (NumberFormatException e) {
//							;
//						}
//						break;
//					}
//				}
//			}
//		}
		
		
//		model.addAttribute("pageNo", String.valueOf(pageNo));
		
		// 將讀到的一頁資料放入request物件內，成為它的屬性物件
		
		// 使用Cookie來儲存目前讀取的網頁編號，Cookie的名稱為memberId + "pageNo"
		// -----------------------
//		Cookie pnCookie = new Cookie(memberId + "pageNo", String.valueOf(pageNo));
//		// 設定Cookie的存活期為30天
//		pnCookie.setMaxAge(30 * 24 * 60 * 60);
//		// 設定Cookie的路徑為 Context Path
//		pnCookie.setPath(request.getContextPath());
//		// 將Cookie加入回應物件內
//		response.addCookie(pnCookie);
////		log.info("瀏覽商品：pageNo=" + pageNo);
		
		return "productMaintain/ClothMaintainList";
//		return "productMaintain/BookMaintainList";
	}

	}

	
