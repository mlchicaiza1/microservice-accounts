package com.banco.cuentas.mapper;

import com.banco.cuentas.domain.Account;
import com.banco.cuentas.dto.AccountDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface AccountMapper {
    AccountDTO toDTO(Account account);

    @Mapping(target = "version", ignore = true)
    Account toEntity(AccountDTO accountDTO);
}
