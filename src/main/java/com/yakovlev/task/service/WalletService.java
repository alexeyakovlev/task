package com.yakovlev.task.service;

import com.yakovlev.task.model.WalletDTO;
import com.yakovlev.task.util.exception.WalletNotFoundException;

import java.util.UUID;

/**
 * Created by alexi on 03.08.2025
 */
public interface WalletService {
    WalletDTO getById(UUID id) throws WalletNotFoundException;
}
