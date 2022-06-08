package com.barunsw.store.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.barunsw.store.vo.ImageVo;
import com.barunsw.store.vo.ProductVo;
import com.barunsw.store.vo.SellerVo;

@Mapper
public interface ProductDao {
	public List<ProductVo> selectProductList(ProductVo paramData);
	public List<ImageVo> selectProductImageList(ImageVo paramData);
	public int insertProduct(ProductVo paramData) throws Exception;
	public int insertProductImage(ImageVo paramData) throws Exception;
	public int deleteProduct(ProductVo paramData) throws Exception;
	
	public List<SellerVo> selectSellerList(SellerVo paramData);
}
