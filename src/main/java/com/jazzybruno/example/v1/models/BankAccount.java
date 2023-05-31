package com.jazzybruno.example.v1.models;

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
    @NotNull
    private int accountBalance;
    @Column
    @NotNull
    private String accountNumber;
    @Column
    @NotNull
    private Date createdAt;

    public BankAccount(String accountName, int accountBalance, String accountNumber, Date createdAt) {
        this.accountName = accountName;
        this.accountBalance = accountBalance;
        this.accountNumber = accountNumber;
        this.createdAt = createdAt;
    }
}
