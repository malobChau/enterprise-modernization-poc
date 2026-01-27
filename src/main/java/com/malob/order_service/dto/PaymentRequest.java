package com.malob.order_service.dto;

public class PaymentRequest {
    private String orderId;
    private double amount;

    public PaymentRequest(String orderId, double amount) {
        this.orderId = orderId;
        this.amount = amount;
    }

    public String getOrderId() {
        return orderId;
    }

    public double getAmount() {
        return amount;
    }
}
