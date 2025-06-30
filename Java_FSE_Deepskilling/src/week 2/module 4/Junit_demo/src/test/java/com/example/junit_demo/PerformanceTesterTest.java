package com.example.junit_demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTimeout;
import java.time.Duration;

public class PerformanceTesterTest {

    PerformanceTester tester = new PerformanceTester();

    @Test
    void testPerformTaskWithinTimeLimit() {
        System.out.println("🚀 Running testPerformTaskWithinTimeLimit()");
        assertTimeout(Duration.ofSeconds(1), () -> {
            tester.performTask();
        });
    }
}
