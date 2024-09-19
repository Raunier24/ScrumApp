package com.scrumapp.scrum.dtos.response;

import com.scrumapp.scrum.models.ERole;

public class AuthResponse {
    private String token;
    private ERole role;

    // Constructor sin argumentos
    public AuthResponse() {
    }

    // Constructor con argumentos
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

    // Método toString
    @Override
    public String toString() {
        return "AuthResponse{" +
                "token='" + token + '\'' +
                ", role=" + role +
                '}';
    }

    // Método equals
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AuthResponse that = (AuthResponse) o;

        if (token != null ? !token.equals(that.token) : that.token != null) return false;
        return role == that.role;
    }

    // Método hashCode
    @Override
    public int hashCode() {
        int result = token != null ? token.hashCode() : 0;
        result = 31 * result + (role != null ? role.hashCode() : 0);
        return result;
    }
}