package com.pragma.powerup.application.security;

public class AuthenticationResponse {
    private String jwt;

    public AuthenticationResponse() {
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
