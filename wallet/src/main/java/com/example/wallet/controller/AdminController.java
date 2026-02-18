package com.example.wallet.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

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

    // Dashboard Stats
    @GetMapping("/dashboard")
    public AdminDashboardResponse getDashboardStats() {
        return adminService.getDashboardStats();
    }

    // Get All Users
    @GetMapping("/users")
    public List<UserResponse> getAllUsers() {
        return adminService.getAllUsers();
    }

    // 🔥 DELETE USER
    @DeleteMapping("/users/{id}")
    public String deleteUser(@PathVariable Long id) {

        adminService.deleteUser(id);

        return "User deleted successfully";
    }
}
