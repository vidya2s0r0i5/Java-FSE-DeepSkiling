package com.example.junit_demo;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.mockito.ArgumentMatchers.*;

public class MyServiceArgumentTest {

    @Test
    void testArgumentMatching() {
        ExternalApi mockApi = mock(ExternalApi.class);
        when(mockApi.getData(anyString())).thenReturn("Mocked Response");

        MyService service = new MyService(mockApi);
        String result = service.fetchData("user123");

        verify(mockApi).getData(eq("user123")); // verifying with specific value
        System.out.println("Returned: " + result);
    }
}
