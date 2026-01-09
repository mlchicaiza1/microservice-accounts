package com.banco.cuentas.contracts;

import com.banco.cuentas.domain.Account;

public interface IAccountService {
    Account createAccount(Account account);
    Account getAccount(Long id);
    Account getAccountByNumber(String accountNumber);
}
