package com.pragma.powerup.infrastructure.feignClient;

public final class BearerHeader {
    private final String token;

    private BearerHeader(String token) {
        this.token = token;
    }

    @Override
    public String toString() {
        return String.format("%s", token);
    }

    public static BearerHeader of(String token) {
        return new BearerHeader(token);
    }
}