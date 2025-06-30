package com.example.junit_demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    Calculator calculator = new Calculator();

    @Test
    void testAdd() {
        System.out.println("Running testAdd()");
        assertEquals(10, calculator.add(7, 3));
    }

    @Test
    void testSubtract() {
        System.out.println("Running testSubtract()");
        assertEquals(4, calculator.subtract(9, 5));
    }

    @Test
    void testMultiply() {
        System.out.println("Running testMultiply()");
        assertEquals(20, calculator.multiply(4, 5));
    }

    @Test
    void testDivide() {
        System.out.println("Running testDivide()");
        assertEquals(3, calculator.divide(9, 3));
    }

    
    @Test
    void testDivideByZero() {
        System.out.println("Running testDivideByZero()");
        assertThrows(ArithmeticException.class, () -> calculator.divide(5, 0));
    }

    }
