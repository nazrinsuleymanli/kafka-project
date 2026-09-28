package com.kafka.order_service.producer;

import com.kafka.events.OrderCreated;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class OrderProducer {

    private final KafkaTemplate<String, OrderCreated> kafkaTemplate;
    //tool to send message to the Kafka

    public OrderProducer(KafkaTemplate<String, OrderCreated> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendOrderCreated(OrderCreated event) {
        kafkaTemplate.send("order-events", event);
    }
}