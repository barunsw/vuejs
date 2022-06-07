package com.barunsw.store.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.barunsw.store.constants.Result;
import com.barunsw.store.service.ProductService;
import com.barunsw.store.vo.ImageVo;
import com.barunsw.store.vo.ProductVo;
import com.barunsw.store.vo.ResponseVo;
import com.barunsw.store.vo.SellerVo;

@Controller
public class ProductController {
	private static Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/api/product/list", method=RequestMethod.GET)
	public ResponseEntity<ResponseVo> selectProductList() {
		LOGGER.debug("selectProductList");
		
		ResponseVo response = new ResponseVo();
		try {
			List<ProductVo> data = productService.selectProductList();
			response.setData(data);
			response.setResult(Result.OK);
		}
		catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
			
			response.setResult(Result.FAIL);
			response.setMessage(ex.getMessage());
		}
		
		return response.build();
	}
	
	@RequestMapping(value="/api/product/detail/{id}", method=RequestMethod.GET)
	public ResponseEntity<ResponseVo> selectProductDetail(@PathVariable String id) {
		LOGGER.debug("selectProductDetail productId:" + id);
		
		ResponseVo response = new ResponseVo();
		try {
			List<ProductVo> data = productService.selectProductDetail(id);
			response.setData(data);
			response.setResult(Result.OK);
		}
		catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
			
			response.setResult(Result.FAIL);
			response.setMessage(ex.getMessage());
		}
		
		return response.build();
	}
	
	@RequestMapping(value="/api/product/image/{id}", method=RequestMethod.GET)
	public ResponseEntity<ResponseVo> selectProductImage(@PathVariable String id) {
		LOGGER.debug("selectProductImage productId:" + id);
		
		ResponseVo response = new ResponseVo();
		try {
			List<ImageVo> data = productService.selectProductImageList(id);
			response.setData(data);
			response.setResult(Result.OK);
		}
		catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
			
			response.setResult(Result.FAIL);
			response.setMessage(ex.getMessage());
		}
		
		return response.build();
	}
	
	@RequestMapping(value="/api/seller/list", method=RequestMethod.GET)
	public ResponseEntity<ResponseVo> selectSellerList() {
		ResponseVo response = new ResponseVo();
		try {
			List<SellerVo> data = productService.selectSellerList();
			response.setData(data);
			response.setResult(Result.OK);
		}
		catch (Exception ex) {
			LOGGER.error(ex.getMessage(), ex);
			
			response.setResult(Result.FAIL);
			response.setMessage(ex.getMessage());
		}
		
		return response.build();
	}
}
