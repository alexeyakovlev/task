package com.yakovlev.task.controller;

import com.yakovlev.task.model.OperationType;
import com.yakovlev.task.model.WalletDTO;
import com.yakovlev.task.service.WalletService;
import com.yakovlev.task.util.exception.WalletNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Created by alexi on 03.08.2025
 */
@RestController
@RequestMapping("/api/v1")
public class WalletController {
    private final WalletService walletService;

    public WalletController(WalletService walletService) {
        this.walletService = walletService;
    }

    @GetMapping("/wallets/{WALLET_UUID}")
    @ResponseStatus(HttpStatus.OK)
    public WalletDTO getWalletById(@PathVariable UUID WALLET_UUID) throws WalletNotFoundException {
        return walletService.getById(WALLET_UUID);
    }

    @PostMapping("/wallet/save")
    @ResponseStatus(HttpStatus.CREATED)
    public WalletDTO createWallet(@RequestBody WalletDTO walletDTO) {
        return walletService.save(walletDTO);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public WalletDTO changeAmount(@RequestBody WalletDTO walletDTO) throws WalletNotFoundException {
        if (walletDTO.getOperationType().equals(OperationType.DEPOSIT))
            return walletService.deposit(walletDTO);
        else
            return walletService.withdraw(walletDTO);
    }
}
