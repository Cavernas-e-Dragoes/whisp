package com.ced.properties;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import static com.ced.constants.ApplicationConstants.SECURITY;

@Configuration
@ConfigurationProperties(prefix = SECURITY)
public class SecurityProperties {

    private String token;
    private Long expiration;

    public Long getExpiration() {
        return expiration;
    }

    public void setExpiration(Long expiration) {
        this.expiration = expiration;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
