package com.kafka.payment_service.consumer;

import com.kafka.payment_service.event.OrderCreatedEvent;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class PaymentConsumer {

    @KafkaListener(topics = "order-events", groupId = "payment-group")
    public void handleOrderCreated(OrderCreatedEvent event) {
        System.out.println("Payment received order: " + event.getOrderId()
                + " for " + event.getProduct() + " amount: " + event.getAmount());
        // burada real ödəniş məntiqi olardı
    }
}
