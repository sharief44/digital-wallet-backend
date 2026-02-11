package com.example.wallet.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.wallet.dto.response.TransactionResponse;
import com.example.wallet.service.WalletService;

@RestController
@RequestMapping("/api/wallet")
public class WalletController {

    private final WalletService walletService;

    // Manual constructor
    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    // ADD MONEY
    @PostMapping("/add")
    public ResponseEntity<String> addMoney(
            @RequestParam Long userId,
            @RequestParam Double amount) {

        return ResponseEntity.ok(
                walletService.addMoney(userId, amount)
        );
    }

    // GET BALANCE
    @GetMapping("/balance/{userId}")
    public ResponseEntity<Double> getBalance(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                walletService.getBalance(userId)
        );
    }

    // TRANSFER MONEY
    @PostMapping("/transfer")
    public ResponseEntity<String> transferMoney(
            @RequestParam Long fromUserId,
            @RequestParam Long toUserId,
            @RequestParam Double amount) {

        return ResponseEntity.ok(
                walletService.transferMoney(fromUserId, toUserId, amount)
        );
    }

    // GET TRANSACTIONS
    @GetMapping("/transactions/{userId}")
    public ResponseEntity<List<TransactionResponse>> getTransactions(
            @PathVariable Long userId) {

        return ResponseEntity.ok(
                walletService.getTransactions(userId)
        );
    }
}
