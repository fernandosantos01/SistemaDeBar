package com.POO.Sistema_De_Bar.model;

public enum UserRole {
    ADMIN("admin"),
    GARCOM("garcom");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}