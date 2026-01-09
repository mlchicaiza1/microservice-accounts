package com.banco.cuentas.service;

import com.banco.cuentas.contracts.ITransactionService;
import com.banco.cuentas.domain.Account;
import com.banco.cuentas.domain.AccountStatus;
import com.banco.cuentas.domain.Transaction;
import com.banco.cuentas.domain.TransactionType;
import com.banco.cuentas.repository.AccountRepository;
import com.banco.cuentas.repository.TransactionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TransactionService implements ITransactionService {

    private final TransactionRepository transactionRepository;
    private final AccountRepository accountRepository;

    @Transactional
    public Transaction createTransaction(String accountNumber, Transaction transaction) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found"));

        if (account.getStatus() != AccountStatus.ACTIVE) {
            throw new RuntimeException("Account is not active");
        }

        BigDecimal currentBalance = account.getBalance();
        BigDecimal amount = transaction.getAmount();

        if (amount.compareTo(BigDecimal.ZERO) <= 0) {
            throw new RuntimeException("Amount must be greater than zero");
        }

        if (transaction.getType() == TransactionType.DEBIT) {
            if (currentBalance.compareTo(amount) < 0) {
                throw new RuntimeException("Insufficient balance");
            }
            currentBalance = currentBalance.subtract(amount);
        } else if (transaction.getType() == TransactionType.CREDIT) {
            currentBalance = currentBalance.add(amount);
        }

        account.setBalance(currentBalance);
        accountRepository.save(account);

        transaction.setAccount(account);
        transaction.setResultingBalance(currentBalance);
        transaction.setDate(LocalDateTime.now());
        
        return transactionRepository.save(transaction);
    }

    @Transactional(readOnly = true)
    public List<Transaction> getTransactionsByAccount(Long accountId) {
         Account account = accountRepository.findById(accountId)
                .orElseThrow(() -> new RuntimeException("Account not found"));
        return transactionRepository.findByAccount(account);
    }

    @Transactional(readOnly = true)
    public List<Transaction> getTransactionsByAccountNumber(String accountNumber) {
        Account account = accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found with number: " + accountNumber));
        return transactionRepository.findByAccount(account);
    }
}
