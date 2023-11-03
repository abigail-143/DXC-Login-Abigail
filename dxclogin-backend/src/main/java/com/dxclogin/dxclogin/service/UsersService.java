package com.dxclogin.dxclogin.service;

import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private String accessToken;
    private String response;
    private String username;
    private String clearance;

    public String getAccessToken() {
        return accessToken;
    }

    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClearance() {
        return clearance;
    }

    public void setClearance(String clearance) {
        this.clearance = clearance;
    }

    public UsersService(String accessToken, String response, String username, String clearance) {
        this.accessToken = accessToken;
        this.response = response;
        this.username = username;
        this.clearance = clearance;
    }

    public UsersService(String response) {
        this.response = response;
    }

    public UsersService() {}
}

