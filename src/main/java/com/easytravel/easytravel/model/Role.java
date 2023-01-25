package com.easytravel.easytravel.model;

public enum Role {
    USER("User"),
    ADMIN("Admin"),
    DIRECTOR("Director");

    private final String value;

    private Role(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
