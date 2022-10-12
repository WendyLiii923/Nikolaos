package com.java18.nikolaos.listColth.model.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.java18.nikolaos.listColth.model.ClothBean;
import com.java18.nikolaos.listColth.model.ClothCategoryBean;
import com.java18.nikolaos.listColth.model.dao.ClothDao;
import com.java18.nikolaos.listColth.model.service.ClothService;



@Service
@Transactional
public class ClothServiceImpl implements ClothService{
	//ClothDao指定不到ClothDaoImpl?
	ClothDao clothDao;
//	@Autowired
	public ClothServiceImpl(ClothDao clothDao) {
		this.clothDao = clothDao;
	}

	
	@Override
	public List<ClothBean> getAllClothesProducts() {
		return clothDao.getAllClothesProducts();
	}

	@Override
	public void updateAllStocks() {
		List<ClothBean> allProducts = clothDao.getAllClothesProducts();
		for (ClothBean cb : allProducts) {
			
			if (cb.getStock() != null && cb.getStock() < 2) {
				clothDao.updateClothStock(cb.getId(), cb.getStock() + 5);
			}
		}
		
	}

	@Override
	public List<ClothCategoryBean> getAllClothCategories() {
		
		return clothDao.getAllClothCategories();
	}

	@Override
	public List<ClothBean> getClothesProductsByCategory(String clothCategory) {
		return clothDao.getClothesProductsByCategory(clothCategory);
	}

	@Override
	public ClothBean getClothProductById(int clothId) {

		return clothDao.getClothProductById(clothId);
	}

	@Override
	public void addClothProduct(ClothBean cloth) {
		clothDao.addClothProduct(cloth);
		
	}

	@Override
	public ClothCategoryBean getClothCategoryById(int clothCategoryId) {
		return clothDao.getClothCategoryById(clothCategoryId);
	}

	@Override
	public List<ClothCategoryBean> getClothCategoryList() {
		return clothDao.getClothCategoryList();
	}


//	public Map<Integer, ClothBean> getPageClothes(int pageNo)
	@Override
	public Map<Integer, ClothBean> getPageClothes() {
		// log.info("維護書籍資料之顯示書籍功能之Service，讀取一頁商品資料之 pageNo=" + pageNo);
		Map<Integer, ClothBean> map = null;
		map = clothDao.getPageClothes();
		return map;
	}


	@Override
	public int getTotalPages() {
//		log.info("BookServiceImpl#getTotalPages");
		int n = 0 ;
		n=clothDao.getTotalPages();
		return n;
	}


	@Override
	public void updateCloth(ClothBean bean, long sizeInBytes) {
//		log.info("更新書籍資料之Service, bean=" + bean 
//				+ ", sizeInBytes=" + sizeInBytes);
	clothDao.updateCloth(bean, sizeInBytes);
	}


	@Override
	public List<ClothBean> findAllCategories() {
		
		return clothDao.getAllClothesProducts();
	}


	@Override
	public void deleteById(int id) {
//		log.info("刪除書籍功能之Service, 書籍主鍵值：" + bookId);
		
		clothDao.deleteById(id);
		
	}


	@Override
	public void save(ClothBean bean) {
		clothDao.save(bean);
		
//		log.info("新增書籍功能之Service: 資料新增成功, BookBean=" + bean);
		
	}


	@Override
	public ClothBean findById(int id) {
//		log.info("更新書籍資料之前置作業之Service, 書籍主鍵值：" + bookId);
		ClothBean bean = null;
		bean = clothDao.findById(id);
		return bean;
	}

	
}

