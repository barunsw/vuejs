package com.barunsw.store.vo;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class ProductVo {
	private String id;
	private int type;
	private String productName;
	private long productPrice;
	private long deliveryPrice;
	private long addDeliveryPrice;
	private String tags;
	private int outboundDays;
	private String sellerId;
	private String categoryId;
	private String createdDate;
	private String category1;
	private String category2;
	private String category3;
	private String imagePath;
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public long getProductPrice() {
		return productPrice;
	}

	public void setProductPrice(long productPrice) {
		this.productPrice = productPrice;
	}

	public long getDeliveryPrice() {
		return deliveryPrice;
	}

	public void setDeliveryPrice(long deliveryPrice) {
		this.deliveryPrice = deliveryPrice;
	}

	public long getAddDeliveryPrice() {
		return addDeliveryPrice;
	}

	public void setAddDeliveryPrice(long addDeliveryPrice) {
		this.addDeliveryPrice = addDeliveryPrice;
	}

	public String getTags() {
		return tags;
	}

	public void setTags(String tags) {
		this.tags = tags;
	}

	public int getOutboundDays() {
		return outboundDays;
	}

	public void setOutboundDays(int outboundDays) {
		this.outboundDays = outboundDays;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(String categoryId) {
		this.categoryId = categoryId;
	}

	public String getCreatedDate() {
		return createdDate;
	}

	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}

	public String getCategory1() {
		return category1;
	}

	public void setCategory1(String category1) {
		this.category1 = category1;
	}

	public String getCategory2() {
		return category2;
	}

	public void setCategory2(String category2) {
		this.category2 = category2;
	}

	public String getCategory3() {
		return category3;
	}

	public void setCategory3(String category3) {
		this.category3 = category3;
	}

	public String getImagePath() {
		return imagePath;
	}

	public void setImagePath(String imagePath) {
		this.imagePath = imagePath;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
