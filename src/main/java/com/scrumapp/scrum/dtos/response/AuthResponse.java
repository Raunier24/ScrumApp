package com.scrumapp.scrum.dtos.response;

import com.scrumapp.scrum.models.ERole;

public class AuthResponse {
    private String token;
    private ERole role;

    public AuthResponse() {
    }

    public AuthResponse(String token, ERole role) {
        this.token = token;
        this.role = role;
    }

    // Getters y Setters
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ERole getRole() {
        return role;
    }

    public void setRole(ERole role) {
        this.role = role;
    }

    // Métodos toString, equals, hashCode
}