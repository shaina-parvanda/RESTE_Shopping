package com.restful.electronicshopping.entity;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "product")
public class Product/* implements Serializable */{

	//private static final long serialVersionUID = 1L;
	int productID;
	String productName;
	String productCategory;
	double price;
	int currentStockNumbers;
	String remarks;
	int priceMin;
	int priceMax;
	public Product( String productName, String productCategory, double price, int currentstocknumbers, String remarks) {
		super();
		//this.productID = productID;
		this.productName = productName;
		this.productCategory = productCategory;
		this.price = price;
		this.currentStockNumbers = currentstocknumbers;
		this.remarks = remarks;
	}
	public int getCurrentStockNumbers() {
		return currentStockNumbers;
	}
	//@XmlElement
	public void setCurrentStockNumbers(int currentStockNumbers) {
		this.currentStockNumbers = currentStockNumbers;
	}
	public int getPriceMin() {
		return priceMin;
	}
	//@XmlElement
	public void setPriceMin(int priceMin) {
		this.priceMin = priceMin;
	}
	public int getPriceMax() {
		return priceMax;
	}
	//@XmlElement
	public void setPriceMax(int priceMax) {
		this.priceMax = priceMax;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getProductID() {
		return productID;
	}
	//@XmlElement
	public void setProductID(int productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	//@XmlElement
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	//@XmlElement
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public double getPrice() {
		return price;
	}
	//@XmlElement
	public void setPrice(double price) {
		this.price = price;
	}
	public String getRemarks() {
		return remarks;
	}
	//@XmlElement
	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}
}
