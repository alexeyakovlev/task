package com.yakovlev.task.repository;

import com.yakovlev.task.model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * Created by alexi on 03.08.2025
 */
public interface WalletRepository extends JpaRepository<Wallet, UUID> {
}
