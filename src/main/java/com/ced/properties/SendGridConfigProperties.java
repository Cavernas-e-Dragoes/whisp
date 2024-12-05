package com.ced.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import static com.ced.constants.ApplicationConstants.SENDGRID;

@Configuration
@ConfigurationProperties(prefix = SENDGRID)
public class SendGridConfigProperties {

    private String apiKey;
    private String senderEmail;

    public String getApiKey() {
        return apiKey;
    }

    public void setApiKey(String apiKey) {
        this.apiKey = apiKey;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }
}
