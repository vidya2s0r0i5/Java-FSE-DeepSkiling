package com.example.junit_demo;

public class LogService {
    private final Logger logger;

    public LogService(Logger logger) {
        this.logger = logger;
    }

    public void writeLog(String message) {
        logger.log(message);
    }
}
