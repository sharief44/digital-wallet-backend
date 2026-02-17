package com.example.wallet.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.wallet.dto.response.AdminDashboardResponse;
import com.example.wallet.dto.response.UserResponse;
import com.example.wallet.entity.Role;
import com.example.wallet.repository.TransactionRepository;
import com.example.wallet.repository.UserRepository;
import com.example.wallet.repository.WalletRepository;

@Service
public class AdminService {

    private final UserRepository userRepository;
    private final WalletRepository walletRepository;
    private final TransactionRepository transactionRepository;

    public AdminService(UserRepository userRepository,
                        WalletRepository walletRepository,
                        TransactionRepository transactionRepository) {
        this.userRepository = userRepository;
        this.walletRepository = walletRepository;
        this.transactionRepository = transactionRepository;
    }

    // ===============================
    // Dashboard Stats
    // ===============================
    public AdminDashboardResponse getDashboardStats() {

        long totalUsers = userRepository.count();
        long totalAdmins = userRepository.countByRole(Role.ROLE_ADMIN);
        long totalWallets = walletRepository.count();
        long totalTransactions = transactionRepository.count();
        BigDecimal totalMoney = walletRepository.getTotalMoney();

        return new AdminDashboardResponse(
                totalUsers,
                totalAdmins,
                totalWallets,
                totalTransactions,
                totalMoney
        );
    }

    
    // Get All Users
    
    public List<UserResponse> getAllUsers() {

        return userRepository.findAll()
                .stream()
                .map(user -> new UserResponse(
                        user.getId(),
                        user.getName(),
                        user.getEmail(),
                        user.getRole().name()                ))
                .toList();
    }
}
