package com.example.wallet.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.wallet.dto.response.TransactionResponse;
import com.example.wallet.entity.Transaction;
import com.example.wallet.entity.User;
import com.example.wallet.entity.Wallet;
import com.example.wallet.repository.TransactionRepository;
import com.example.wallet.repository.UserRepository;
import com.example.wallet.repository.WalletRepository;
import com.example.wallet.service.WalletService;

@Service
@Transactional
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;
    private final UserRepository userRepository;
    private final TransactionRepository transactionRepository;

    // Manual constructor (NO Lombok)
    public WalletServiceImpl(
            WalletRepository walletRepository,
            UserRepository userRepository,
            TransactionRepository transactionRepository) {

        this.walletRepository = walletRepository;
        this.userRepository = userRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public Double getBalance(Long userId) {

        return userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"))
                .getWallet()
                .getBalance();
    }

    @Override
    public String addMoney(Long userId, Double amount) {

        if (amount <= 0) {
            throw new RuntimeException("Amount must be greater than zero");
        }

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Wallet wallet = user.getWallet();

        // update balance
        wallet.setBalance(wallet.getBalance() + amount);
        walletRepository.save(wallet);

        // create transaction
        Transaction txn = new Transaction();
        txn.setAmount(amount);
        txn.setType("CREDIT");
        txn.setTimestamp(LocalDateTime.now());
        txn.setWallet(wallet);

        transactionRepository.save(txn);

        return "Money added successfully";
    }

    @Override
    public String transferMoney(Long fromUserId, Long toUserId, Double amount) {

        if (amount <= 0) {
            throw new RuntimeException("Amount must be greater than zero");
        }

        if (fromUserId.equals(toUserId)) {
            throw new RuntimeException("Sender and receiver cannot be same");
        }

        User fromUser = userRepository.findById(fromUserId)
                .orElseThrow(() -> new RuntimeException("Sender not found"));

        User toUser = userRepository.findById(toUserId)
                .orElseThrow(() -> new RuntimeException("Receiver not found"));

        Wallet fromWallet = fromUser.getWallet();
        Wallet toWallet = toUser.getWallet();

        if (fromWallet.getBalance() < amount) {
            throw new RuntimeException("Insufficient balance");
        }

        // 1️⃣ Deduct from sender
        fromWallet.setBalance(fromWallet.getBalance() - amount);
        walletRepository.save(fromWallet);

        // 2️⃣ Add to receiver
        toWallet.setBalance(toWallet.getBalance() + amount);
        walletRepository.save(toWallet);

        // 3️⃣ Sender transaction (DEBIT)
        Transaction debitTxn = new Transaction();
        debitTxn.setAmount(amount);
        debitTxn.setType("DEBIT");
        debitTxn.setTimestamp(LocalDateTime.now());
        debitTxn.setWallet(fromWallet);
        transactionRepository.save(debitTxn);

        // 4️⃣ Receiver transaction (CREDIT)
        Transaction creditTxn = new Transaction();
        creditTxn.setAmount(amount);
        creditTxn.setType("CREDIT");
        creditTxn.setTimestamp(LocalDateTime.now());
        creditTxn.setWallet(toWallet);
        transactionRepository.save(creditTxn);

        return "Transfer successful";
    }

    @Override
    public List<TransactionResponse> getTransactions(Long userId) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new RuntimeException("User not found"));

        Wallet wallet = user.getWallet();

        List<Transaction> transactions =
                transactionRepository.findByWalletId(wallet.getId());

        return transactions.stream().map(txn -> {
            TransactionResponse dto = new TransactionResponse();
            dto.setId(txn.getId());
            dto.setAmount(txn.getAmount());
            dto.setType(txn.getType());
            dto.setTimestamp(txn.getTimestamp());
            return dto;
        }).toList();
    }
}
