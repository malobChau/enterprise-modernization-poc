package com.malob.common.event;

import java.io.Serializable;

public class OrderCreatedEvent implements Serializable {

    private String orderId;
    private double amount;

    public OrderCreatedEvent() {
    }

    public OrderCreatedEvent(String orderId, double amount) {
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
