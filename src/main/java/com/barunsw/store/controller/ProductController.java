package com.barunsw.store.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import com.barunsw.store.vo.ResponseVo;

@Controller
public class ProductController {
	private static Logger LOGGER = LoggerFactory.getLogger(ProductController.class);
	
	@Autowired
	private ProductService productService;
	
	@RequestMapping(value="/api/product/list", method=RequestMethod.GET)
	public ResponseEntity<ResponseVo> selectProductList() {
		ResponseVo response = new ResponseVo();
		try {
			List<Map> data = productService.selectProductList();
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
		ResponseVo response = new ResponseVo();
		try {
			List<Map> data = productService.selectProductDetail(id);
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
			Map paramData = new HashMap();
			
			List<Map> data = productService.selectSellerList(paramData);
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
