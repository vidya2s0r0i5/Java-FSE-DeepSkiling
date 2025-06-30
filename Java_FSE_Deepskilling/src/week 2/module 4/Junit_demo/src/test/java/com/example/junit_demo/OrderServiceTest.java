package com.example.junit_demo;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {

    @Test
    void testOrderStatusWithMultipleReturns() {
        OrderApi mockApi = mock(OrderApi.class);

        when(mockApi.getOrderStatus())
            .thenReturn("Placed")
            .thenReturn("Packed")
            .thenReturn("Shipped")
            .thenReturn("Delivered");

        OrderService service = new OrderService(mockApi);

        String status1 = service.trackOrder();
        assertEquals("Placed", status1);
        System.out.println("Order Status 1: " + status1);

        String status2 = service.trackOrder();
        assertEquals("Packed", status2);
        System.out.println("Order Status 2: " + status2);

        String status3 = service.trackOrder();
        assertEquals("Shipped", status3);
        System.out.println("Order Status 3: " + status3);

        String status4 = service.trackOrder();
        assertEquals("Delivered", status4);
        System.out.println("Order Status 4: " + status4);

        String status5 = service.trackOrder();
        assertEquals("Delivered", status5);
        System.out.println("Order Status 5: " + status5); // repeats last value

        verify(mockApi, times(5)).getOrderStatus();
    }
}
