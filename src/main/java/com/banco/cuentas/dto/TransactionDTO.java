package com.banco.cuentas.dto;

import com.banco.cuentas.domain.TransactionType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class TransactionDTO {
    private Long id;
    private LocalDateTime date;
    private TransactionType type;
    private BigDecimal amount;
    private BigDecimal resultingBalance;
    private String accountNumber;
}
