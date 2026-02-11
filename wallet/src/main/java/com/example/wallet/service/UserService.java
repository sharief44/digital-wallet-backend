package com.example.wallet.service;

import com.example.wallet.dto.request.LoginRequest;
import com.example.wallet.dto.request.RegisterRequest;
import com.example.wallet.dto.response.LoginResponse;

public interface UserService {

    String registerUser(RegisterRequest request);

    LoginResponse login(LoginRequest request);
}
