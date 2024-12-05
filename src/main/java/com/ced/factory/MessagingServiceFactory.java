package com.ced.factory;

import com.ced.service.MessagingService;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class MessagingServiceFactory {

    private final Map<String, MessagingService> services;

    public MessagingServiceFactory(Map<String, MessagingService> services) {
        this.services = services;
    }

    public MessagingService getService(String providerName) {
        MessagingService service = services.get(providerName.toLowerCase());
        if (service == null) {
            throw new IllegalArgumentException("Provedor não suportado: " + providerName);
        }
        return service;
    }
}
