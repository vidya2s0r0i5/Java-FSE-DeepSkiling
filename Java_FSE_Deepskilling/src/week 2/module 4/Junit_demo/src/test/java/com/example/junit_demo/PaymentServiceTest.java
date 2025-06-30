package com.example.junit_demo;

import org.junit.jupiter.api.Test;
import org.mockito.InOrder;

import static org.mockito.Mockito.*;

public class PaymentServiceTest {

    @Test
    void testInteractionOrder() {
        PaymentApi mockApi = mock(PaymentApi.class);
        PaymentService service = new PaymentService(mockApi);

        service.processPayment();

        InOrder inOrder = inOrder(mockApi);
        inOrder.verify(mockApi).initiatePayment();
        inOrder.verify(mockApi).confirmPayment();
        inOrder.verify(mockApi).sendReceipt();

        System.out.println("Verified method call order: initiate → confirm → receipt");
    }
}
