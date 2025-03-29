package com.example.Banking.mapper;

import com.example.Banking.dto.AccountDto;
import com.example.Banking.model.Account;

public class AccountMapper {
    public static Account mapToAccount(AccountDto accountdto) {
        Account account =new Account(
                accountdto.getAccountId(),
                accountdto.getAccountNumber(),
                accountdto.getAccountType(),
                accountdto.getAccountHolderName(),
                accountdto.getBalance()
        );

        return account;
    }

    public static AccountDto mapToAccountDto(Account account) {
        AccountDto accountdto =new AccountDto(
                account.getAccountId(),
        account.getAccountNumber(),
        account.getAccountHolderName(),
        account.getAccountType(),
        account.getBalance());
                return accountdto;
    }
}
