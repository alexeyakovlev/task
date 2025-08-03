package com.yakovlev.task.model;

import java.math.BigDecimal;
import java.util.UUID;

/**
 * Created by alexi on 03.08.2025
 */
public class WalletDTO {
    private UUID id;
    private BigDecimal amount;
    private OperationType operationType;

    public WalletDTO() {
    }

    public WalletDTO(UUID id, BigDecimal amount, OperationType operationType) {
        this.id = id;
        this.amount = amount;
        this.operationType = operationType;
    }

    public WalletDTO(BigDecimal amount) {
        this.amount = amount;
    }

    public WalletDTO(UUID id, BigDecimal amount) {
        this.id = id;
        this.amount = amount;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public OperationType getOperationType() {
        return operationType;
    }

    public void setOperationType(OperationType operationType) {
        this.operationType = operationType;
    }
}
