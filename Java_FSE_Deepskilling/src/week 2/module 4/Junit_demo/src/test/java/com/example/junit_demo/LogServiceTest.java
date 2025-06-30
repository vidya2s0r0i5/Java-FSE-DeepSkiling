package com.example.junit_demo;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class LogServiceTest {

    @Test
    void testVoidMethodThrowsException() {
        Logger mockLogger = mock(Logger.class);

        // Stub the void method to throw an exception
        doThrow(new RuntimeException("Logging failed"))
                .when(mockLogger).log("CRITICAL");

        LogService service = new LogService(mockLogger);

        RuntimeException exception = assertThrows(RuntimeException.class, () -> {
            service.writeLog("CRITICAL");
        });

        assertEquals("Logging failed", exception.getMessage());
        verify(mockLogger).log("CRITICAL");
    }
}
