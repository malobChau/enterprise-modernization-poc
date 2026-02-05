package com.malob.order_service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(
    properties = {
        "spring.kafka.bootstrap-servers=localhost:9092",
        "spring.kafka.consumer.enabled=false",
        "spring.kafka.producer.enabled=false"
    }
)
class OrderServiceApplicationTests {

    @Test
    void contextLoads() {
    }
}

