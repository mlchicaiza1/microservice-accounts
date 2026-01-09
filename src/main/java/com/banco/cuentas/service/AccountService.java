package com.banco.cuentas.service;

import com.banco.cuentas.contracts.IAccountService;
import com.banco.cuentas.domain.Account;
import com.banco.cuentas.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AccountService implements IAccountService {

    private final AccountRepository accountRepository;

    @Transactional
    public Account createAccount(Account account) {
        if (accountRepository.findByAccountNumber(account.getAccountNumber()).isPresent()) {
            throw new RuntimeException("Account with number " + account.getAccountNumber() + " already exists");
        }
        return accountRepository.save(account);
    }

    @Transactional(readOnly = true)
    public Account getAccount(Long id) {
        return accountRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Account not found with id: " + id));
    }

    @Transactional(readOnly = true)
    public Account getAccountByNumber(String accountNumber) {
        return accountRepository.findByAccountNumber(accountNumber)
                .orElseThrow(() -> new RuntimeException("Account not found with number: " + accountNumber));
    }
}
