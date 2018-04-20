package com.restful.electronicshopping.entity;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")
public class Product {

	int productID;
	String productName;
	String productCategory;
	double price;
	int currentStockNumbers;
	String remarks;
	public Product(int productID, String productName, String productCategory, double price, int currentstocknumbers,
			String remarks) {
		super();
		this.productID = productID;
		this.productName = productName;
		this.productCategory = productCategory;
		this.price = price;
		this.currentStockNumbers = currentstocknumbers;
		this.remarks = remarks;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getProductID() {
		return productID;
	}
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getCurrentstocknumbers() {
		return currentStockNumbers;
	}
	public void setCurrentstocknumbers(int currentstocknumbers) {
		this.currentStockNumbers = currentstocknumbers;
	}
	public String getRemarks() {
		return remarks;
	}
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
