package com.malob.order_service.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.Data;

@Data
public class CreateOrderRequest {

    @NotNull
    private String productName;

    @Positive
    private double amount;

    // getters and setters
}
