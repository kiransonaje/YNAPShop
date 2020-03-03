package com.ynap.shop.model;

import java.math.BigDecimal;

/**
 * Author: Kiran Sonaje
 * 03/03/2020
 */
public class Product {

	private String price;
	private String productId;
	private String productName;
	private BigDecimal total;
	
	//Default Constructor
	public Product() {
	
	}
	
	//Constructor
	public Product(String price, String productId, String productName) {		
		this.price = price;
		this.productId = productId;
		this.productName = productName;
	}

	public String getPrice() {
		return price;
	}

	public String getProductId() {
		return productId;
	}

	public String getProductName() {
		return productName;
	}

	public BigDecimal getTotal() {
		return total;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public void setTotal(BigDecimal total) {
		this.total = total;
	}

	@Override
	public String toString() {
		return "\nProduct : [productId :" + productId + " productName : " + productName + " price : " + price + "\n";
	}

}