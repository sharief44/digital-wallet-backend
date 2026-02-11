package com.example.wallet.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.wallet.entity.Transaction;
import com.example.wallet.entity.Wallet;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {

    List<Transaction> findByWalletId(Long walletId);
   
    List<Transaction> findByWallet(Wallet wallet);
}
