package com.java.ecom.dao;

public interface PaymentDAO {
    void addPayment(int orderId, String paymentMethod, String transactionId, String paymentStatus);
    void updatePayment(int paymentId, String paymentStatus);
    void showPendingPayments();
    void showCompletedPayments();
    void showPaymentDetailsByOrderId(int orderId);
    void showPaymentById(int paymentId);
}
