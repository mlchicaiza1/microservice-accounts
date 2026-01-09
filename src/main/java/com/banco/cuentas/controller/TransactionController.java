package com.banco.cuentas.controller;

import com.banco.cuentas.contracts.ITransactionService;
import com.banco.cuentas.dto.TransactionDTO;
import com.banco.cuentas.mapper.TransactionMapper;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/accounts/{accountNumber}/transactions")
@RequiredArgsConstructor
public class TransactionController {

    private final ITransactionService transactionService;
    private final TransactionMapper transactionMapper;

    @PostMapping
    public ResponseEntity<TransactionDTO> createTransaction(@PathVariable String accountNumber, @Valid @RequestBody TransactionDTO transactionDTO) {
        return new ResponseEntity<>(
                transactionMapper.toDTO(transactionService.createTransaction(accountNumber, transactionMapper.toEntity(transactionDTO))),
                HttpStatus.CREATED
        );
    }

    @GetMapping
    public ResponseEntity<List<TransactionDTO>> getTransactions(@PathVariable String accountNumber) {
        return ResponseEntity.ok(
                transactionService.getTransactionsByAccountNumber(accountNumber).stream()
                        .map(transactionMapper::toDTO)
                        .collect(Collectors.toList())
        );
    }
}
