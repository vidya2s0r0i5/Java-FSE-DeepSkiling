package com.example.junit_demo;

public class MyService {
    private final ExternalApi api;

    public MyService(ExternalApi api) {
        this.api = api;
    }

    public String fetchData(String str) {
        return api.getData(str);
    }
}
