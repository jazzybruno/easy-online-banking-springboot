package com.jazzybruno.example.v1.models;

import com.jazzybruno.example.v1.enums.TransactionsType;
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
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long  transactionId;
    @ManyToOne
    @JoinColumn(name = "accountName")
    private BankAccount accountName;
    @Column
    private TransactionsType transactionsType;
    @Column
    private int amount;
    @Column
    private String source;
    @Column
    private String reason;
    @Column
    private String reasonCode;
    @Column
    private Date createdAt;

    public Transaction(BankAccount accountName, TransactionsType transactionsType, int amount, String source, String reason, String reasonCode, Date createdAt) {
        this.accountName = accountName;
        this.transactionsType = transactionsType;
        this.amount = amount;
        this.source = source;
        this.reason = reason;
        this.reasonCode = reasonCode;
        this.createdAt = createdAt;
    }
}
