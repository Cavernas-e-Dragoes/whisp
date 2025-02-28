package com.ced.constants;

public class ApplicationConstants {

    private ApplicationConstants() {
    }

    // JWT and Authorization
    public static final String SECURITY = "security";

    // Contents
    public static final String TEXT_PLAIN = "text/plain";
    public static final String TEXT_HTML = "text/html";

    //Provider and Service Type
    public static final String PROVIDER_SMS = "sms";
    public static final String PROVIDER_ZAP = "whatsapp";
    public static final String PROVIDER_EMAIL = "email";
    public static final String SENDGRID_PATH = "mail/send";

    //Properties
    public static final String SENDGRID = "sendgrid";
    public static final String TWILIO = "twilio";
    public static final String AMQP = "amqp";
}