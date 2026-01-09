package com.banco.cuentas.contracts;

import com.banco.cuentas.domain.Transaction;
import java.util.List;

public interface ITransactionService {
    Transaction createTransaction(String accountNumber, Transaction transaction);
    List<Transaction> getTransactionsByAccount(Long accountId);
    List<Transaction> getTransactionsByAccountNumber(String accountNumber);
}
