package com.ced.listener;

import com.ced.factory.MessagingServiceFactory;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class ContextLoadTest {

    @Autowired
    private MessagingServiceFactory messagingServiceFactory;

    @Test
    void contextLoads() {
        assertNotNull(messagingServiceFactory, "MessagingServiceFactory não está registrado no contexto do Spring");
    }
}
