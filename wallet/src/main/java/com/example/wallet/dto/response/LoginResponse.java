package com.example.wallet.dto.response;

public class LoginResponse {

    private String token;
    private Long userId;
    private String email;
    private String role; // ✅ ADD THIS

    public LoginResponse(String token, Long userId, String email, String role) {
        this.token = token;
        this.userId = userId;
        this.email = email;
        this.role = role; // ✅ ADD THIS
    }

    public String getToken() {
        return token;
    }

    public Long getUserId() {
        return userId;
    }

    public String getEmail() {
        return email;
    }

    public String getRole() { // ✅ ADD THIS
        return role;
    }
}
