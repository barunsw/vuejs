package com.barunsw.store.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ProductDao {
	public List<Map> selectProductList(Map paramData);
	public List<Map> selectProductImageList(Map paramData);
	public int insertProduct(Map paramData) throws Exception;
	public int insertProductImage(Map paramData) throws Exception;

	public List<Map> selectSellerList(Map paramData);
}
