package com.java18.nikolaos.listColth.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.java18.nikolaos.ShoppingCart.model.OrderItem2Bean;
import com.java18.nikolaos.ShoppingCart.model.ShoppingCart;
import com.java18.nikolaos.listColth.model.ClothBean;
import com.java18.nikolaos.register.model.MemberBean;
// 當使用者按下『加入購物車』時，瀏覽器會送出請求到本程式
@Controller
@RequestMapping("/listClothes")
@SessionAttributes({"products_DPP", "ShoppingCart", "loginMember"}) //"LoginOK", "pageNo"
public class BuyClothController {
//	private static Logger log = LoggerFactory.getLogger(BuyBookController.class);

	@SuppressWarnings("unchecked")
	@PostMapping("/BuyCloth.do")
	protected String buyCloth(Model model,
			@RequestParam("id") Integer id,
			@RequestParam("qty") Integer qty //訂單內容物
	) throws ServletException, IOException {
		MemberBean memberBean = (MemberBean) model.getAttribute("loginMember");
		if (memberBean == null) {
			return "redirect:/login/login";
		}
		// 取出存放在session物件內的ShoppingCart物件
		ShoppingCart cart = (ShoppingCart) model.getAttribute("ShoppingCart");
		// 如果找不到ShoppingCart物件
		if (cart == null) {
//			log.info("新建ShoppingCart物件");
			// 就新建ShoppingCart物件
			cart = new ShoppingCart();
			// 並將此新建ShoppingCart的物件放到session物件內，成為它的屬性物件
			model.addAttribute("ShoppingCart", cart);   
		}
		
		Map<Integer, ClothBean> clothMap = (Map<Integer, ClothBean>) model.getAttribute("products_DPP");
		ClothBean bean = clothMap.get(id);
		OrderItem2Bean oib = new OrderItem2Bean(null, bean.getHighlight(),
				id,bean.getCategory(), bean.getDescrip(), null,qty, bean.getName(),bean.getActualPrice());
				cart.addToCart(id, oib);
		
		
		
		
		// 將訂單資料(價格，數量，折扣與BookBean)封裝到OrderItemBean物件內
		 
		// 將OrderItem物件內加入ShoppingCart的物件內
//		cart.addToCart(id, oib); //cart.addToCart(bookId, oib);//註解消除
//		log.info("執行ShoppingCart物件的addToCart(), oib=" + oib);
		return "ShoppingCart/test_ShowCartContent"; 
//		return  "listCloth/showClothes";
//		listCloth/ShowlistCloth
	}
}