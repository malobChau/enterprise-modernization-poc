package com.malob.order_service.service;

import com.malob.common.event.OrderCreatedEvent;
import com.malob.order_service.dto.CreateOrderRequest;
import com.malob.order_service.exception.InvalidOrderException;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderService {

    private final KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate;

    public OrderService(KafkaTemplate<String, OrderCreatedEvent> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public String createOrder(CreateOrderRequest request) {

        // business validation
        if (request.getAmount() > 100000) {
            throw new InvalidOrderException("Order amount too large");
        }

        // publish order event
        OrderCreatedEvent event = new OrderCreatedEvent(
                "ORD-" + System.currentTimeMillis(),
                request.getAmount()
        );

        kafkaTemplate.send("order-created-topic", event);

        return "Order accepted and sent for payment processing";
    }
}
