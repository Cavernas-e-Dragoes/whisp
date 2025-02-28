package com.ced.service;

import com.ced.model.MessageRequest;
import com.ced.properties.SendGridConfigProperties;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.SendGrid;
import com.sendgrid.helpers.mail.Mail;
import com.sendgrid.helpers.mail.objects.Content;
import com.sendgrid.helpers.mail.objects.Email;
import org.springframework.stereotype.Service;

import java.io.IOException;

import static com.ced.constants.ApplicationConstants.PROVIDER_EMAIL;
import static com.ced.constants.ApplicationConstants.SENDGRID_PATH;
import static com.ced.constants.ApplicationConstants.TEXT_HTML;

@Service(PROVIDER_EMAIL)
public class EmailService implements MessagingService {

    private final SendGridConfigProperties config;

    public EmailService(SendGridConfigProperties config) {
        this.config = config;
    }

    @Override
    public void sendMessage(final MessageRequest messageRequest) {
        Email from = new Email(config.getSenderEmail());
        Email recipient = new Email(messageRequest.getTo());
        Content content = new Content(TEXT_HTML, messageRequest.getMessage());

        Mail mail = new Mail(from, messageRequest.getSubject(), recipient, content);
        SendGrid sendGrid = new SendGrid(config.getApiKey());

        Request request = new Request();
        try {
            request.setMethod(Method.POST);
            request.setEndpoint(SENDGRID_PATH);
            request.setBody(mail.build());
            sendGrid.api(request);
        } catch (IOException e) {
            throw new RuntimeException("Error to sent mail: " + e.getMessage(), e);
        }
    }
}