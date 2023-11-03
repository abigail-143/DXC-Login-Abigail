package com.dxclogin.dxclogin.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.hibernate.annotations.CreationTimestamp;

import java.sql.Timestamp;

@Entity
public class Tokens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long accessID;
    private String accessToken;

    @CreationTimestamp
    private Timestamp tokenCreation;

    public Tokens() {};
    public Tokens(Long accessID, String accessToken) {
        this.accessID = accessID;
        this.accessToken = accessToken;
    }

    public Long getAccessID() {
        return accessID;
    }

    public void setAccessID(Long accessID) {
        this.accessID = accessID;
    }

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public Timestamp getTokenCreation() {
        return tokenCreation;
    }

    public void setTokenCreation(Timestamp tokenCreation) {
        this.tokenCreation = tokenCreation;
    }
}
