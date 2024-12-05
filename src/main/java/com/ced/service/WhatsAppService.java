package com.ced.service;

import com.ced.model.MessageRequest;
import com.ced.properties.TwilioConfigProperties;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import org.springframework.stereotype.Service;

import static com.ced.constants.ApplicationConstants.PROVIDER_ZAP;

@Service(PROVIDER_ZAP)
public class WhatsAppService implements MessagingService {

    private final TwilioConfigProperties config;

    public WhatsAppService(TwilioConfigProperties config) {
        this.config = config;
        Twilio.init(config.getAccountSid(), config.getAuthToken());
    }

    @Override
    public void sendMessage(final MessageRequest messageRequest) {
        try {
            Message.creator(
                    new com.twilio.type.PhoneNumber("whatsapp:" + messageRequest.getTo()),
                    new com.twilio.type.PhoneNumber("whatsapp:" + config.getPhoneNumber()),
                    messageRequest.getMessage()
            ).create();
            System.out.println("Message from WhatsApp sent to: " + messageRequest.getTo());
        } catch (Exception e) {
            throw new RuntimeException("Was not possible sent the zap message: " + e.getMessage(), e);
        }
    }
}
