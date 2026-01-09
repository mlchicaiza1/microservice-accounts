package com.banco.cuentas.controller;

import com.banco.cuentas.dto.AccountDTO;
import com.banco.cuentas.mapper.AccountMapper;
import com.banco.cuentas.service.AccountService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/accounts")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;
    private final AccountMapper accountMapper;

    @PostMapping
    public ResponseEntity<AccountDTO> createAccount(@Valid @RequestBody AccountDTO accountDTO) {
        return new ResponseEntity<>(
                accountMapper.toDTO(accountService.createAccount(accountMapper.toEntity(accountDTO))),
                HttpStatus.CREATED
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDTO> getAccount(@PathVariable Long id) {
        return ResponseEntity.ok(accountMapper.toDTO(accountService.getAccount(id)));
    }
}
