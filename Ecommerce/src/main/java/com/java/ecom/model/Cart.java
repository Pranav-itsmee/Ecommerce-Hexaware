package com.java.ecom.model;

public class Cart {
	
	private int cartId;
    private int customerId;
    private int productId;
    private int quantity;

    public int getCartId() {
		return cartId;
	}
	public void setCartId(int cartId) {
		this.cartId = cartId;
	}
	public int getCustomerId() {
		return customerId;
	}
	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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
		return "Cart [cartId=" + cartId + ", customerId=" + customerId + ", productId=" + productId + ", quantity="
				+ quantity + ", getCartId()=" + getCartId() + ", getCustomerId()=" + getCustomerId()
				+ ", getProductId()=" + getProductId() + ", getQuantity()=" + getQuantity() + "]";
	}
	
}
