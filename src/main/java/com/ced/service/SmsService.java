package com.ced.service;

import com.ced.model.MessageRequest;
import com.ced.properties.TwilioConfigProperties;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.stereotype.Service;

import static com.ced.constants.ApplicationConstants.PROVIDER_SMS;

@Service(PROVIDER_SMS)
public class SmsService implements MessagingService {

    private final TwilioConfigProperties config;

    public SmsService(TwilioConfigProperties config) {
        this.config = config;
        Twilio.init(config.getAccountSid(), config.getAuthToken());
    }

    @Override
    public void sendMessage(final MessageRequest messageRequest) {
        try {
            Message.creator(
                    new com.twilio.type.PhoneNumber(messageRequest.getTo()),
                    new com.twilio.type.PhoneNumber(config.getPhoneNumber()),
                    messageRequest.getMessage()
            ).create();
            System.out.println("SMS sent to: " + messageRequest.getTo());
        } catch (Exception e) {
            throw new RuntimeException("Error to sent SMS: " + e.getMessage(), e);
        }
    }
}


