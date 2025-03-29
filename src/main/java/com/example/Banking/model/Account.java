package com.example.Banking.model;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name= "accounts")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long accountId;

    @Column (name= "account_holder_name")
    private String accountHolderName;

    private String accountNumber;

    private String accountType;
    private double balance;

    /*public Account(long accountId, String accountHolderName, String accountNumber, String accountType, double balance) {
        this.accountId = accountId;
        this.accountHolderName = accountHolderName;
        this.accountNumber = accountNumber;
        this.accountType = accountType;
        this.balance = balance;

    }

    public Account() {

    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public void setAccountHoldername(String accountHolderName) {
        this.accountHolderName= accountHolderName;
    }

    private void setBalance(double balance) {
        this.balance= balance;
    }*/
}
