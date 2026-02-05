package com.malob.payment_service.listener;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

import com.malob.common.event.OrderCreatedEvent;


@Component
public class PaymentEventListener {

    @KafkaListener(
        topics = "order-created-topic",
        groupId = "payment-group"
    )
    public void handleOrderCreated(OrderCreatedEvent event) {

        System.out.println("Received OrderCreatedEvent for order: " + event.getOrderId());

        if (event.getAmount() > 50000) {
            System.out.println("Payment flagged for manual review for order: " + event.getOrderId());
        } else {
            System.out.println("Payment processed successfully for order: " + event.getOrderId());
        }
    }
}
