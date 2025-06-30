package com.example.junit_demo;

import org.junit.jupiter.api.Test;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class NotificationServiceTest {

    @Test
    void testVoidMethod_doNothing() {
        ExternalMessageApi mockApi = mock(ExternalMessageApi.class);
        doNothing().when(mockApi).sendNotification(anyString());

        NotificationService service = new NotificationService(mockApi);
        service.notifyUser("Hello!");

        verify(mockApi).sendNotification("Hello!");
    }

    @Test
    void testVoidMethod_doThrow() {
        ExternalMessageApi mockApi = mock(ExternalMessageApi.class);
        doThrow(new RuntimeException("Failed to send")).when(mockApi).sendNotification("fail");

        NotificationService service = new NotificationService(mockApi);

        Exception exception = assertThrows(RuntimeException.class, () -> {
            service.notifyUser("fail");
        });
        assertEquals("Failed to send", exception.getMessage());

        verify(mockApi).sendNotification("fail");
    }

    @Test
    void testVoidMethod_doAnswer() {
        ExternalMessageApi mockApi = mock(ExternalMessageApi.class);

        doAnswer(invocation -> {
            String msg = invocation.getArgument(0);
            System.out.println("Intercepted message: " + msg);
            return null;
        }).when(mockApi).sendNotification(anyString());

        NotificationService service = new NotificationService(mockApi);
        service.notifyUser("Testing with doAnswer");

        verify(mockApi).sendNotification("Testing with doAnswer");
    }
}
