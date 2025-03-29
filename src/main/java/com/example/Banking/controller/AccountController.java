package com.example.Banking.controller;

import com.example.Banking.dto.AccountDto;
import com.example.Banking.service.AccountsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountController {


    private final AccountsService accountsService;

    @Autowired
    public AccountController(AccountsService accountsService) {
        this.accountsService = accountsService;
    }

    @PostMapping("/api/save")
    public ResponseEntity<AccountDto> addAccount(@RequestBody AccountDto accountDto){
return new ResponseEntity<>(accountsService.CreateAccount(accountDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<AccountDto> getAccountData( @PathVariable Long id){
        AccountDto accountdto= accountsService.GetAccount(id);
        return ResponseEntity.ok(accountdto);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<AccountDto> updateAccount(@PathVariable Long id, @RequestBody AccountDto accountDto){
        AccountDto acc= accountsService.UpdateAccount(id, accountDto);
        return ResponseEntity.ok(acc);
    }
    @GetMapping("/getAll")
    public ResponseEntity <List<AccountDto>> getAllAccount(){
        List<AccountDto> lsofacc= accountsService.GetAllaccount();
        return ResponseEntity.ok(lsofacc);
    }
}
