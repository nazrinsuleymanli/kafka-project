package com.kafka.order_service.dto;

import lombok.Data;

@Data
public class OrderRequest {
    private String orderId;
    private String product;
    private double amount;
}
