package com.example.wallet.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.wallet.dto.response.AdminDashboardResponse;
import com.example.wallet.dto.response.UserResponse;
import com.example.wallet.service.AdminService;

@RestController
@RequestMapping("/api/admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    // =====================================
    // Dashboard Statistics Endpoint
    // =====================================
    @GetMapping("/dashboard")
    public AdminDashboardResponse getDashboardStats() {
        return adminService.getDashboardStats();
    }

    // =====================================
    // Get All Users Endpoint
    // =====================================
    @GetMapping("/users")
    public List<UserResponse> getAllUsers() {
        return adminService.getAllUsers();
    }
}
