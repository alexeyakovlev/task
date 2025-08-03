package com.yakovlev.task.service.impl;

import com.yakovlev.task.model.Wallet;
import com.yakovlev.task.model.WalletDTO;
import com.yakovlev.task.repository.WalletRepository;
import com.yakovlev.task.service.WalletService;
import com.yakovlev.task.util.WalletMapper;
import com.yakovlev.task.util.exception.WalletNotFoundException;

import java.util.UUID;

/**
 * Created by alexi on 03.08.2025
 */
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;

    public WalletServiceImpl(WalletRepository walletRepository) {
        this.walletRepository = walletRepository;
    }

    private Wallet getWalletById(UUID id) throws WalletNotFoundException {
        Wallet walletById = walletRepository.findById(id)
                .orElseThrow(() -> new WalletNotFoundException("Wallet not found"));
        return walletById;
    }

    @Override
    public WalletDTO getById(UUID id) throws WalletNotFoundException {
        Wallet walletById = getWalletById(id);
        return WalletMapper.toWalletDTO(walletById);
    }

    @Override
    public WalletDTO save(WalletDTO walletDTO) {
        Wallet walletToSave = WalletMapper.toWallet(walletDTO);
        return WalletMapper.toWalletDTO(walletRepository.save(walletToSave));
    }

    @Override
    public WalletDTO deposit(WalletDTO walletDTO) throws WalletNotFoundException {
        Wallet walletById = getWalletById(walletDTO.getId());
        walletById.setAmount(walletById.getAmount().add(walletDTO.getAmount()));
        return WalletMapper.toWalletDTO(walletById);
    }

    @Override
    public WalletDTO withdraw(WalletDTO walletDTO) throws WalletNotFoundException {
        Wallet walletById = getWalletById(walletDTO.getId());
        walletById.setAmount(walletById.getAmount().subtract(walletDTO.getAmount()));
        return WalletMapper.toWalletDTO(walletById);
    }
}
