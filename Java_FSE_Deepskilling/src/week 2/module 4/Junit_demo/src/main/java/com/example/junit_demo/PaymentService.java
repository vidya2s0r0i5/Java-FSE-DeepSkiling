package com.example.junit_demo;

public class PaymentService {
    private final PaymentApi api;

    public PaymentService(PaymentApi api) {
        this.api = api;
    }

    public void processPayment() {
        api.initiatePayment();
        api.confirmPayment();
        api.sendReceipt();
    }
}
