package com.example.junit_demo;

public class OrderService {
    private final OrderApi api;

    public OrderService(OrderApi api) {
        this.api = api;
    }

    public String trackOrder() {
        return api.getOrderStatus();
    }
}
