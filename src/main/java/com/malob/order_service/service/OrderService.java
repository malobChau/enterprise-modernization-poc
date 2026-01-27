package com.malob.order_service.service;

import com.malob.order_service.dto.CreateOrderRequest;
import com.malob.order_service.dto.PaymentRequest;
import com.malob.order_service.exception.InvalidOrderException;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderService {

    private final RestTemplate restTemplate;

    public OrderService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @CircuitBreaker(name = "paymentService", fallbackMethod = "paymentFallback")
    public String createOrder(CreateOrderRequest request) {

        // business validation
        if (request.getAmount() > 100000) {
            throw new InvalidOrderException("Order amount too large");
        }

        // call payment-service
        PaymentRequest paymentRequest =
                new PaymentRequest("ORD-" + System.currentTimeMillis(), request.getAmount());

        String paymentResponse = restTemplate.postForObject(
                "http://payment-service:8082/payments",
                paymentRequest,
                String.class
        );

        if ("PAYMENT_FAILED".equals(paymentResponse)) {
            throw new InvalidOrderException("Payment failed for order");
        }

        return "Order created & payment successful";
    }

    // fallback method (must match method signature + Throwable)
 public String paymentFallback(CreateOrderRequest request, RuntimeException ex) {
    return "Order placed, but payment service is temporarily unavailable";
}
}
