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
public class Deposit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long depositId;
    @Column
    private int amount;
    @ManyToOne
    @JoinColumn(name = "accountTo")
    private BankAccount accountTo;

    public Deposit(int amount, BankAccount accountTo) {
        this.amount = amount;
        this.accountTo = accountTo;
    }
}
