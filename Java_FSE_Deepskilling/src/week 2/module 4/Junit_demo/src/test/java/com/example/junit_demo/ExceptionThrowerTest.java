package com.example.junit_demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExceptionThrowerTest {

    ExceptionThrower thrower = new ExceptionThrower();

    @Test
    void testThrowExceptionWithNull() {
        System.out.println("Running testThrowExceptionWithNull()");
        assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException(null);
        });
    }

    @Test
    void testThrowExceptionWithEmpty() {
        System.out.println("Running testThrowExceptionWithEmpty()");
        assertThrows(IllegalArgumentException.class, () -> {
            thrower.throwException("");
        });
    }

    @Test
    void testThrowExceptionWithValidInput() {
        System.out.println("Running testThrowExceptionWithValidInput()");
        assertDoesNotThrow(() -> {
            thrower.throwException("Valid input");
        });
    }
}
