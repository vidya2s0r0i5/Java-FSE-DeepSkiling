package com.example.junit_demo;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;

public class MyServiceVerifyTest {

    @Test
    public void testVerifyInteraction() {
        // 1️⃣ Create a mock object
        ExternalApi mockApi = mock(ExternalApi.class);

        // 2️⃣ Inject into service
        MyService service = new MyService(mockApi);

        // 3️⃣ Call method (this should internally call getData on mock)
        service.fetchData("");

        // 4️⃣ Verify the interaction
        verify(mockApi).getData(""); // ✅ Test will fail if getData was not called
        System.out.println("Verified: getData() was called");
    }
}
