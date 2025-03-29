package com.example.Banking.service;

import com.example.Banking.dto.AccountDto;
import org.springframework.http.ResponseEntity;

import java.util.List;


public interface AccountsService {

    AccountDto CreateAccount(AccountDto accountDto);
    AccountDto GetAccount(Long id);
    AccountDto UpdateAccount( Long id, AccountDto accountDto);
    List<AccountDto> GetAllaccount();
}
