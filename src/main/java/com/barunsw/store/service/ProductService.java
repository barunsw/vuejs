package com.barunsw.store.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.barunsw.store.mapper.ProductDao;
import com.barunsw.store.vo.ImageVo;
import com.barunsw.store.vo.ProductVo;
import com.barunsw.store.vo.SellerVo;

@Service
public class ProductService {
	@Autowired
	private ProductDao productDao;
	
	public List<ProductVo> selectProductList() {
		ProductVo paramData = new ProductVo();
		paramData.setType(1);
		
		return productDao.selectProductList(paramData);
	}
	
	public List<ProductVo> selectProductDetail(String id) {
		ProductVo paramData = new ProductVo();
		paramData.setType(3);
		paramData.setId(id);
		
		return productDao.selectProductList(paramData);
	}

	public List<ImageVo> selectProductImageList(String id) {
		ImageVo paramData = new ImageVo();
		paramData.setType(2);
		paramData.setProductId(id);
		
		return productDao.selectProductImageList(paramData);
	}
	
	public int insertProduct(ProductVo paramData) throws Exception {
		return productDao.insertProduct(paramData);
	}
	
	public int insertProductImage(ImageVo paramData) throws Exception {
		return productDao.insertProductImage(paramData);
	}
	
	public int deleteProduct(String id) throws Exception {
		ProductVo paramData = new ProductVo();
		paramData.setId(id);
		
		return productDao.deleteProduct(paramData);
	}
	
	public List<SellerVo> selectSellerList() {
		SellerVo paramData = new SellerVo();
		return productDao.selectSellerList(paramData);
	}
}
