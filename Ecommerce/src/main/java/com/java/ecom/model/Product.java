package com.java.ecom.model;

public class Product {
	private String name;
    private double price;
    private String description;
    private int stockQuantity;
    
    private int productId;
    public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getStockQuantity() {
		return stockQuantity;
	}
	public void setStockQuantity(int stockQuantity) {
		this.stockQuantity = stockQuantity;
	}
	@Override
	public String toString() {
		return "Product [name=" + name + ", price=" + price + ", description=" + description + ", stockQuantity="
				+ stockQuantity + ", productId=" + productId + ", getProductId()=" + getProductId() + ", getName()="
				+ getName() + ", getPrice()=" + getPrice() + ", getDescription()=" + getDescription()
				+ ", getStockQuantity()=" + getStockQuantity() + "]";
	}
	


}
