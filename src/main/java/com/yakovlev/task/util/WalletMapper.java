package com.yakovlev.task.util;

import com.yakovlev.task.model.Wallet;
import com.yakovlev.task.model.WalletDTO;

/**
 * Created by alexi on 03.08.2025
 */
public class WalletMapper {
    public static WalletDTO toWalletDTO(Wallet wallet) {
        return new WalletDTO(wallet.getId(), wallet.getAmount());
    }

    public static Wallet toWallet(WalletDTO walletDTO) {
        return new Wallet(walletDTO.getId(), walletDTO.getAmount());
    }
}
