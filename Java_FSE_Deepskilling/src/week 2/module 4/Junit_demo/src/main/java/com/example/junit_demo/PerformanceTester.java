package com.example.junit_demo;

public class PerformanceTester {

    public void performTask() {
        // Simulate some work
        try {
            System.out.println("Starting task...");
            Thread.sleep(800); // 800 milliseconds delay
            System.out.println("Task completed");
        } catch (InterruptedException e) {
            throw new RuntimeException("Task interrupted", e);
        }
    }
}
