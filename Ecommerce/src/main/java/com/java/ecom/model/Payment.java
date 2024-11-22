package com.java.ecom.model;

import java.sql.Date;

public class Payment {
	
	private int paymentId;
    private int orderId;
    private Date paymentDate;
    private String paymentMethod;
    private String transactionId;
    private String paymentStatus;
    
    public int getPaymentId() {
		return paymentId;
	}
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	public int getOrderId() {
		return orderId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public Date getPaymentDate() {
		return paymentDate;
	}
	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getPaymentStatus() {
		return paymentStatus;
	}
	public void setPaymentStatus(String paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	@Override
	public String toString() {
		return "Payment [paymentId=" + paymentId + ", orderId=" + orderId + ", paymentDate=" + paymentDate
				+ ", paymentMethod=" + paymentMethod + ", transactionId=" + transactionId + ", paymentStatus="
				+ paymentStatus + ", getPaymentId()=" + getPaymentId() + ", getOrderId()=" + getOrderId()
				+ ", getPaymentDate()=" + getPaymentDate() + ", getPaymentMethod()=" + getPaymentMethod()
				+ ", getTransactionId()=" + getTransactionId() + ", getPaymentStatus()=" + getPaymentStatus() + "]";
	}
	
}
