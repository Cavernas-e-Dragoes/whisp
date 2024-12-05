package com.ced.service;

import com.ced.model.MessageRequest;

public interface MessagingService {
    void sendMessage(final MessageRequest messageRequest);
}

