package com.java18.nikolaos.listColth.model.dao.impl;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.java18.nikolaos.listColth.exception.ClothNotFoundException;
import com.java18.nikolaos.listColth.model.ClothBean;
import com.java18.nikolaos.listColth.model.ClothCategoryBean;
import com.java18.nikolaos.listColth.model.dao.ClothCategoryDao;
import com.java18.nikolaos.listColth.model.dao.ClothDao;

@Repository
public class ClothDaoImpl implements ClothDao {
	
	
//	public static final int recordsPerPage = GlobalService.RECORDS_PER_PAGE; // 預設值：每頁三筆
	private int totalPages = -1;

	SessionFactory factory;
	
	ClothCategoryDao clothCategoryDao;
	

	
@Autowired
	public ClothDaoImpl(SessionFactory factory, ClothCategoryDao clothCategoryDao) {
		this.factory = factory;
		this.clothCategoryDao = clothCategoryDao;
	}

	@Override
	public List<ClothBean> getAllClothesProducts() {
		List<ClothBean> beans = new ArrayList<>();
		String hql = "FROM ClothBean";//Entity = java class name //Table = 第一個字小寫java class name
		Session session = factory.getCurrentSession();
		beans = session.createQuery(hql, ClothBean.class)
				.getResultList();
		return beans;
	}

	@Override
	public void updateClothStock(int clothId, int newQuantity) {
		String hql = "UPDATE ClothBean c SET c.stock = :stock WHERE c.id = :id";
		Session session = factory.getCurrentSession();
		session.createQuery(hql).setParameter("stock", newQuantity)
		.setParameter("id", clothId).executeUpdate();
		
	}

	@Override
	public List<ClothCategoryBean> getAllClothCategories() {
		Session session = factory.getCurrentSession();
		String hql = "SELECT new com.java18.nikolaos.listColth.model.ClothCategoryBean(ccb.id, ccb.category) FROM ClothCategoryBean ccb";
		List<ClothCategoryBean> list = session.createQuery(hql, ClothCategoryBean.class).getResultList();
		return list;
	}

	@Override
	public List<ClothBean> getClothesProductsByCategory(String clothCategory) {
		Session session = factory.getCurrentSession();
		String hql = "FROM ClothCategoryBean ccb WHERE ccb.category = :category";
		List<ClothBean> list = session.createQuery(hql, ClothBean.class).setParameter("category", clothCategory)
				.getResultList();
		return list;
	}

	@Override
	public ClothBean getClothProductById(int clothProductId) {
		Session session = factory.getCurrentSession();
		ClothBean cb = session.get(ClothBean.class, clothProductId);
		if (cb == null) {
			throw new ClothNotFoundException("產品編號：" + clothProductId + "找不到",clothProductId);
		}
		return cb;
	}

	@Override
	public void addClothProduct(ClothBean clothProduct) {
		Session session = factory.getCurrentSession();
		// 外鍵欄位是null的原因
		ClothCategoryBean ccb = getClothCategoryById(clothProduct.getClothCategoryId());
		clothProduct.setClothCategoryBean(ccb);
		session.save(clothProduct);
		
	}

	@Override
	public ClothCategoryBean getClothCategoryById(int clothCategoryId) {
		ClothCategoryBean ccb = null;
		Session session = factory.getCurrentSession();
		ccb = session.get(ClothCategoryBean.class, clothCategoryId);
		return ccb;
	}

	@Override
	public List<ClothCategoryBean> getClothCategoryList() {
		Session session = factory.getCurrentSession();
		String hql = "FROM ClothCategoryBean";
		List<ClothCategoryBean> list = session.createQuery(hql, ClothCategoryBean.class).getResultList();
		return list;
	}

	// 依id來刪除單筆記錄
	@Override
	public void deleteById(int id) {
//		log.info("刪除書籍功能之Dao, 書籍主鍵值：" + bookId);
		Session session = factory.getCurrentSession();
//		ClothBean bb = new ClothBean();
//		bb.setId(id);
		ClothBean bb = session.load(ClothBean.class, id);
		session.delete(bb);
	}


	@Override
	public ClothBean findById(int id) {
		ClothBean bean = null;
		Session session = factory.getCurrentSession();
		bean = session.get(ClothBean.class, id);
//		log.info("更新書籍之前置作業之Dao, 書籍主鍵值：" + bookId + ", bean=" + bean);
		return bean;
	}


//	public Map<Integer, ClothBean> getPageClothes(int pageNo)
	@Override
	public Map<Integer, ClothBean> getPageClothes() {
//		log.info("新增書籍之顯示商品功能之Dao，讀取一頁商品資料之 pageNo=" + pageNo);

		Map<Integer, ClothBean> map = new LinkedHashMap<>();
		List<ClothBean> list = new ArrayList<ClothBean>();
		String hql = "FROM ClothBean";
		Session session = factory.getCurrentSession();

//		int startRecordNo = (pageNo - 1) * recordsPerPage; //recordsPerPage未設定

		list = session.createQuery(hql, ClothBean.class)
//					  .setFirstResult(startRecordNo) 
//					  .setMaxResults(recordsPerPage) //recordsPerPage未設定
					  .getResultList();
		
		for (ClothBean bean : list) {
			map.put(bean.getId(), bean);
		}
		
//		log.info("新增書籍之顯示商品功能之Dao，存放商品資料之map=" + map);
		return map;
	}


	@Override
	public long getRecordCounts() {
		long count = 0; // 必須使用 long 型態
		String hql = "SELECT count(*) FROM ClothBean";
		Session session = factory.getCurrentSession();
		List<Long> list = session.createQuery(hql, Long.class)
				                 .getResultList();
		if (list.size() > 0) {
			count = list.get(0);
		}
//		log.info("RecordCounts=" + count);
		return count;
	}


	// 計算販售的商品總共有幾頁
	@Override
	public int getTotalPages() {
//		 注意下一列敘述的每一個型態轉換
//				totalPages = (int) (Math.ceil(getRecordCounts() / (double) recordsPerPage)); //recordsPerPage 未設定    
//				log.info("totalPages=" + totalPages);
				return totalPages;
	}


	@Override
	public String getAllClothCategoriesTag(String selected) {
		String ans = "";
//		List<String> list = getAllClothCategories();
//		ans += "<SELECT name='category'>";
//		for (String cate : list) {
//			if (cate.equals(selected)) {
//				ans += "<option value='" + cate 
//					   + "' selected>" + cate + "</option>";
//			} else {
//				ans += "<option value='" + cate + "'>" 
//			           + cate + "</option>";
//			}
//		}
//		ans += "</SELECT>";
////		log.info("ans=" + ans);
	return ans;
	}


	@Override
	public void updateCloth(ClothBean bean, long sizeInBytes) {
		Session session = factory.getCurrentSession();

		if (bean.getClothCategoryBean() == null) {
			ClothCategoryBean cb = clothCategoryDao.findById(bean.getClothCategoryId());
			bean.setClothCategoryBean(cb);
		}
		if (sizeInBytes == -1) { // 不修改圖片
			updateCloth(bean);
			return;
		}
		session.saveOrUpdate(bean);
		
	}
	
	
	
	public void updateCloth(ClothBean bean) {
		Session session = factory.getCurrentSession();
		ClothBean b0 = null;
		b0 = session.get(ClothBean.class, bean.getId());
		bean.setStock(b0.getStock());
		bean.setPriceStr(b0.getPriceStr());//注意ClothBean 沒有欄位
		bean.setPhoto(b0.getPhoto());
		bean.setFile_Name(b0.getFile_Name()); //file_Name
		session.evict(b0);
		session.saveOrUpdate(bean);
		return;
	}

	

	// 新增一筆記錄---
	@Override
	public void save(ClothBean bean) {
		Session session = factory.getCurrentSession();
		if (bean.getClothCategoryBean() == null) {
			ClothCategoryBean cb = clothCategoryDao.findById(bean.getClothCategoryId());
			bean.setClothCategoryBean(cb);
			bean.setCategory(cb.getCategory());
		}
		bean.setCategory(bean.getClothCategoryBean().getCategory());
		session.save(bean);
//		log.info("維護商品資料功能之Dao: 資料新增成功, BookBean=" + bean);
		
	}
	
	
	

	
	
	
}


