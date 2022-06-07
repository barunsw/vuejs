package com.barunsw.store.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barunsw.store.mapper.ProductDao;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	
	public List<Map> selectProductList() {
		Map paramData = new HashMap();
		paramData.put("type", 1);
		
		return productDao.selectProductList(paramData);
	}
	
	public List<Map> selectProductDetail(String id) {
		Map paramData = new HashMap();
		paramData.put("type", 3);
		paramData.put("id", id);
		
		return productDao.selectProductList(paramData);
	}

	public List<Map> selectProductImageList(String id) {
		Map paramData = new HashMap();
		paramData.put("type", 2);
		paramData.put("id", id);
		
		return productDao.selectProductImageList(paramData);
	}
	
	public int insertProduct(Map paramData) throws Exception {
		return productDao.insertProduct(paramData);
	}
	
	public int insertProductImage(Map paramData) throws Exception {
		return productDao.insertProductImage(paramData);
	}
	
	public List<Map> selectSellerList(Map paramData) {
		return productDao.selectSellerList(paramData);
	}
}
