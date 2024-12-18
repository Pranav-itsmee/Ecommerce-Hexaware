package com.java.ecom.model;

public class OrderItem {
	
	private int orderItemId;
    private int orderId;
    private int productId;
    private int quantity;
    
    public int getOrderItemId() {
		return orderItemId;
	}
	public void setOrderItemId(int orderItemId) {
		this.orderItemId = orderItemId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	@Override
	public String toString() {
		return "OrderItem [orderItemId=" + orderItemId + ", orderId=" + orderId + ", productId=" + productId
				+ ", quantity=" + quantity + ", getOrderItemId()=" + getOrderItemId() + ", getOrderId()=" + getOrderId()
				+ ", getProductId()=" + getProductId() + ", getQuantity()=" + getQuantity() + "]";
	}
	
}
