package com.malob.payment_service.controller;

import org.springframework.web.bind.annotation.*;

import com.malob.payment_service.dto.PaymentRequest;

@RestController
@RequestMapping("/payments")
public class PaymentController {

    @PostMapping
    public String processPayment(@RequestBody PaymentRequest request) {

        if (request.getAmount() > 50000) {
            return "PAYMENT_FAILED";
        }

        return "PAYMENT_SUCCESS";
    }

    @GetMapping("/health")
    public String health() {
        return "Payment Service is running";
    }
}
