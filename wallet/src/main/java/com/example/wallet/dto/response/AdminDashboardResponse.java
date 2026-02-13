package com.example.wallet.dto.response;

import java.math.BigDecimal;

public class AdminDashboardResponse {

    private long totalUsers;
    private long totalAdmins;
    private long totalWallets;
    private long totalTransactions;
    private BigDecimal totalMoneyInSystem;

    public AdminDashboardResponse(long totalUsers,
                                  long totalAdmins,
                                  long totalWallets,
                                  long totalTransactions,
                                  BigDecimal totalMoneyInSystem) {
        this.totalUsers = totalUsers;
        this.totalAdmins = totalAdmins;
        this.totalWallets = totalWallets;
        this.totalTransactions = totalTransactions;
        this.totalMoneyInSystem = totalMoneyInSystem;
    }

    public long getTotalUsers() {
        return totalUsers;
    }

    public long getTotalAdmins() {
        return totalAdmins;
    }

    public long getTotalWallets() {
        return totalWallets;
    }

    public long getTotalTransactions() {
        return totalTransactions;
    }

    public BigDecimal getTotalMoneyInSystem() {
        return totalMoneyInSystem;
    }
}
