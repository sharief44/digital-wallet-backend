package com.example.wallet.service;

import java.math.BigDecimal;
import java.util.List;

import com.example.wallet.dto.response.TransactionResponse;

public interface WalletService {

	Double getBalance(Long userId);

    String addMoney(Long userId, Double amount);

    String transferMoney(Long fromUserId, Long toUserId, Double amount);
    
    List<TransactionResponse> getTransactions(Long userId);
    }
