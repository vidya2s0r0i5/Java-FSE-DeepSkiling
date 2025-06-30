package com.example.junit_demo;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class MyServiceTest {

    @Test
    void testExternalApi() {
        // 1️⃣ Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2️⃣ Stub the method to return mock data
        when(mockApi.getData("")).thenReturn("Mock Data");

        // 3️⃣ Inject the mock into the service
        MyService service = new MyService(mockApi);

        // 4️⃣ Run and assert
        String result = service.fetchData("");
        System.out.println("Result from mock: " + result);
        assertEquals("Mock Data", result);
    }
}
