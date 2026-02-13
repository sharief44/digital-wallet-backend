package com.example.wallet.service;

import java.math.BigDecimal;

import org.springframework.stereotype.Service;

import com.example.wallet.dto.response.AdminDashboardResponse;
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

    public AdminDashboardResponse getDashboardStats() {

        long totalUsers = userRepository.count();
        long totalAdmins = userRepository.countByRole("ROLE_ADMIN");
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
}
