package com.java18.nikolaos.listColth.controller;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Blob;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.CacheControl;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.java18.nikolaos.listColth.model.ClothBean;
import com.java18.nikolaos.listColth.model.service.ClothService;

@Controller
@RequestMapping("/listClothes")
@SessionAttributes({ "LoginOK", "pageNo", "products_DPP", "totalPages" })
public class RetrieveProductsController {
//	private static Logger log = LoggerFactory.getLogger(RetrieveProductsController.class);

	ClothService service;
	ServletContext servletContext;

	@Autowired
	public RetrieveProductsController(ClothService service) {
		this.service = service;
	}

	@GetMapping("/nikolaos")
	public String index() {
		return "boren_index";
	}

	@GetMapping("/getProductPhoto")
	@ResponseBody
	public byte[] getProductPhoto(@RequestParam("id") Integer id) throws Exception {
		ClothBean cb = service.getClothProductById(id);
		if (cb == null) {
			return null;
		} 
		Blob photo= cb.getPhoto();
		return photo.getBytes(1, (int)photo.length());
	}

	@GetMapping("/DisplayPageProducts")
	public String getPageProduct(Model model, HttpServletRequest request, HttpServletResponse response) {
//		@RequestParam(value = "pageNo", required = false) Integer pageNo

		model.addAttribute("baBean", service);
		Map<Integer, ClothBean> clothMap = service.getPageClothes();// 頁數在bookservice 每頁的商品 .getPageClothes()
//		model.addAttribute("pageNo", String.valueOf(pageNo));
		model.addAttribute("totalPages", service.getTotalPages());
		model.addAttribute("products_DPP", clothMap);

//		MemberBean memberBean = (MemberBean) model.getAttribute("LoginOK");
//		if (memberBean == null) {
//			return "redirect:/_02_login/login";
//		}

//		Integer memberId = memberBean.getId();
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

//		log.info("讀取商品資訊，pageNo=" + pageNo);
//		model.addAttribute("baBean", service);
//		Map<Integer, ClothBean> clothMap = service.getPageClothes(pageNo);//頁數在bookservice尚未
//		model.addAttribute("pageNo", String.valueOf(pageNo));
//		model.addAttribute("totalPages", service.getTotalPages());////頁數在bookservice尚未
//		 將讀到的一頁資料放入request物件內，成為它的屬性物件
//		model.addAttribute("products_DPP", clothMap);
//		 使用Cookie來儲存目前讀取的網頁編號，Cookie的名稱為memberId + "pageNo"
//		Cookie pnCookie = new Cookie(memberId + "pageNo", String.valueOf(pageNo));
//		 設定Cookie的存活期為30天
//		pnCookie.setMaxAge(30 * 24 * 60 * 60);
		// 設定Cookie的路徑為 Context Path
//		pnCookie.setPath(request.getContextPath());
		// 將Cookie加入回應物件內
//		response.addCookie(pnCookie);

		return "listCloth/ShowlistCloth";
	}

	@GetMapping("/getClothImage")
	public ResponseEntity<byte[]> getClothImage(@RequestParam("id") Integer id) {
		InputStream is = null;
		OutputStream os = null;
		String file_Name = null;
		String mime_Type = null;
		byte[] media = null;
		ResponseEntity<byte[]> responseEntity = null;
		HttpHeaders headers = new HttpHeaders();
		MediaType mediaType = null;
		Blob blob = null;
		try {
			ClothBean bean = service.findById(id);
			if (bean != null) {
				blob = bean.getPhoto();
				if (blob != null) {
					is = blob.getBinaryStream();
				}
				file_Name = bean.getFile_Name();
			}
			// 如果圖片的來源有問題，就送回預設圖片(/images/NoImage.png)
			if (is == null) {
				file_Name = "NoImage.png";
				is = servletContext.getResourceAsStream("/images/" + file_Name);
			}
			// 由圖片檔的檔名來得到檔案的MIME型態
			mime_Type = servletContext.getMimeType(file_Name);
			if (mime_Type == null) {
				if (file_Name.endsWith("jfif")) {
					mime_Type = "image/jfif";
				}
			}
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
			// 由InputStream讀取位元組，然後由OutputStream寫出
			int len = 0;
			byte[] bytes = new byte[8192];

			while ((len = is.read(bytes)) != -1) {
				baos.write(bytes, 0, len);
			}
			media = baos.toByteArray();
			mediaType = MediaType.valueOf(mime_Type);
			headers.setCacheControl(CacheControl.noCache().getHeaderValue());
			headers.setContentType(mediaType);
			responseEntity = new ResponseEntity<>(media, headers, HttpStatus.OK);

		} catch (Exception ex) {
			ex.printStackTrace();
			throw new RuntimeException("_00_init.util.RetrieveBookImageServlet#doGet()發生Exception: " + ex.getMessage());
		} finally {
			try {
				if (is != null)
					is.close();
			} catch (IOException e) {
				;
			}
			try {
				if (os != null)
					os.close();
			} catch (IOException e) {
				;
			}
		}
		return responseEntity;
	}
//			

}
