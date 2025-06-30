package com.example.junit_demo;

public class NotificationService {
    private final ExternalMessageApi api;

    public NotificationService(ExternalMessageApi api) {
        this.api = api;
    }

    public void notifyUser(String message) {
        api.sendNotification(message);
    }
}

