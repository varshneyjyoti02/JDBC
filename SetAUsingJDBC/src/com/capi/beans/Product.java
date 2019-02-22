package com.capi.beans;

import java.time.LocalDate;



public class Product {
	
	private int saleId;
	
	private int prodCode;
	
	private String prodName;
	
	private String category;
	
//	private LocalDate saleDate;
	
	private int quantity;
	
	private float lineTotal;
	
	private int price;
	@Override
	public String toString() {
		return "Product [saleId=" + saleId + ", prodCode=" + prodCode + ", prodName=" + prodName + ", category="
				+ category + ", quantity=" + quantity + ", lineTotal=" + lineTotal
				+ ", price=" + price + "]";
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int saleId, int prodCode, String prodName, String category, int quantity,
			float lineTotal, int price) {
		super();
		this.saleId = saleId;
		this.prodCode = prodCode;
		this.prodName = prodName;
		this.category = category;
		
		this.quantity = quantity;
		this.lineTotal = lineTotal;
		this.price = price;
	}
	public int getSaleId() {
		return saleId;
	}
	public void setSaleId(int saleId) {
		this.saleId = saleId;
	}
	public int getProdCode() {
		return prodCode;
	}
	public void setProdCode(int prodCode) {
		this.prodCode = prodCode;
	}
	public String getProdName() {
		return prodName;
	}
	public void setProdName(String prodName) {
		this.prodName = prodName;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public float getLineTotal() {
		return lineTotal;
	}
	public void setLineTotal(float lineTotal) {
		this.lineTotal = lineTotal;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	

}
