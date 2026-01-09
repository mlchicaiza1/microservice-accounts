package com.banco.cuentas.dto;

import com.banco.cuentas.domain.AccountStatus;
import com.banco.cuentas.domain.AccountType;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;

@Data
public class AccountDTO {
    private Long id;
    private String accountNumber;
    private AccountType type;
    private BigDecimal balance;
    private AccountStatus status;
    private LocalDate creationDate;
}
