package com.jazzybruno.example.v1.models;

import com.jazzybruno.example.v1.enums.BankAccountType;
import com.sun.istack.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class BankAccount {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long accountId;
    @Column
    @NotNull
    private String accountName;

    @Column
    private BankAccountType bankAccountType;
    @Column
    @NotNull
    private int accountBalance;
    @Column
    @NotNull
    private String accountNumber;
    @Column
    @NotNull
    private Date createdAt;

    public BankAccount(String accountName, BankAccountType bankAccountType, int accountBalance, String accountNumber, Date createdAt) {
        this.accountName = accountName;
        this.bankAccountType = bankAccountType;
        this.accountBalance = accountBalance;
        this.accountNumber = accountNumber;
        this.createdAt = createdAt;
    }
}
