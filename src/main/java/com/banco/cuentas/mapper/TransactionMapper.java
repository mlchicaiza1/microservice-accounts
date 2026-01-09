package com.banco.cuentas.mapper;

import com.banco.cuentas.domain.Transaction;
import com.banco.cuentas.dto.TransactionDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface TransactionMapper {
    
    @Mapping(target = "accountNumber", source = "account.accountNumber")
    TransactionDTO toDTO(Transaction transaction);

    @Mapping(target = "account", ignore = true)
    Transaction toEntity(TransactionDTO transactionDTO);
}
