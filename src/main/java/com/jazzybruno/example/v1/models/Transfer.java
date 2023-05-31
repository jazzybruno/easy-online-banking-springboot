package com.jazzybruno.example.v1.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long transferId;
    @Column
    private int amount;
    @ManyToOne
    @JoinColumn(name = "accountFrom")
    private BankAccount accountFrom;
    @ManyToOne
    @JoinColumn(name = "accountTo")
    private BankAccount accountTo;

    public Transfer(int amount, BankAccount accountFrom, BankAccount accountTo) {
        this.amount = amount;
        this.accountFrom = accountFrom;
        this.accountTo = accountTo;
    }
}
