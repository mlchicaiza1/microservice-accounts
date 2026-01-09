package com.banco.cuentas.mapper;

import com.banco.cuentas.domain.Account;
import com.banco.cuentas.dto.AccountDTO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDTO toDTO(Account account);
    Account toEntity(AccountDTO accountDTO);
}
