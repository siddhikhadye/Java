package com.example.Banking.service.Impl;

import com.example.Banking.dto.AccountDto;
import com.example.Banking.mapper.AccountMapper;
import com.example.Banking.model.Account;
import com.example.Banking.repository.AccountRepository;
import com.example.Banking.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

@Service
public class AccountServiceImpl implements AccountsService {

    private AccountRepository accountRepository;

    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository){
        this.accountRepository = accountRepository;

    }

    @Override
    public AccountDto CreateAccount(AccountDto accountDto) {
        Account account = AccountMapper.mapToAccount(accountDto);
        Account savedAccount= accountRepository.save(account);
        return AccountMapper.mapToAccountDto(savedAccount);
    }

    @Override
    public AccountDto GetAccount(Long id) {
        Account getaccountobj= accountRepository
                .findById(id)
                .orElseThrow(()-> new RuntimeException());

        return AccountMapper.mapToAccountDto(getaccountobj);
    }

    @Override
    public AccountDto UpdateAccount(Long id, AccountDto accountDto) {
        Account account= AccountMapper.mapToAccount(accountDto);
       Account accounts= accountRepository.findById(id).orElseThrow(()-> new RuntimeException());

       String acc= account.getAccountType();
       String acch= account.getAccountHolderName();
       String accountNumber= account.getAccountNumber();
       double balance = account.getBalance();

        accounts.setAccountType(acc);
        accounts.setAccountHolderName(acch);
        accounts.setAccountNumber(accountNumber);
        accounts.setBalance(balance);

        Account accountl= accountRepository.save(accounts);

        return AccountMapper.mapToAccountDto(accountl);
    }

    public List<AccountDto> GetAllaccount(){
        List<Account> listOfAcc= accountRepository.findAll();
        List<AccountDto> listofDto= listOfAcc.stream().map(AccountMapper::mapToAccountDto).collect(Collectors.toList());
        return listofDto;

    }

}
