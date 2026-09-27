package com.kafka.order_service.controller;

import com.kafka.order_service.event.OrderCreatedEvent;
import com.kafka.order_service.producer.OrderProducer;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/orders")
public class OrderController {

    private final OrderProducer orderProducer;

    public OrderController(OrderProducer orderProducer) {
        this.orderProducer = orderProducer;
    }

    @PostMapping
    public String createOrder(@RequestBody OrderCreatedEvent event) {
        orderProducer.sendOrderCreated(event);
        return "Order sent: " + event.getOrderId();
    }
}
