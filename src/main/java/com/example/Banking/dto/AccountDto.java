package com.example.Banking.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;


@Data
@AllArgsConstructor
public class AccountDto {

    private long accountId;
    private String accountHolderName;
    private String accountNumber;
    private String accountType;
    private double balance;


    /*public AccountDto(long accountId, String accountNumber, String accountHolderName, String accountType, double balance) {
    }*/
}
