package com.ced.listener;

import com.ced.factory.MessagingServiceFactory;
import com.ced.model.MessageRequest;
import com.ced.service.MessagingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class MessagingListener {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessagingListener.class);
    private final MessagingServiceFactory serviceFactory;

    public MessagingListener(MessagingServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    @RabbitListener(queues = "#{@dynamicQueueName}")
    public void sendMessage(MessageRequest messageRequest) {
        LOGGER.info("Message received from {}, to {}", messageRequest.getChannel(), messageRequest.getTo());
        MessagingService service = serviceFactory.getService(messageRequest.getChannel());
        service.sendMessage(messageRequest);
        LOGGER.info("Message sent to {}", messageRequest.getTo());
    }
}