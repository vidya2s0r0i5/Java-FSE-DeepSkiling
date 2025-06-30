package com.example.junit_demo;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class OrderedTests {

    @Test
    @Order(3)
    void testC() {
        System.out.println("Running testC (Order 3)");
    }

    @Test
    @Order(1)
    void testA() {
        System.out.println("Running testA (Order 1)");
    }

    @Test
    @Order(2)
    void testB() {
        System.out.println("Running testB (Order 2)");
    }
}
