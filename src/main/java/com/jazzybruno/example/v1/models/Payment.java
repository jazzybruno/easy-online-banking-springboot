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
public class Payment {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long paymentId;
    @Column
    private String  beneficiary;
    @Column
    private String beneficiaryAccountNumber;
    @Column
    private String reason;
    @Column
    private String reasonCode;
    @Column
    private String status;
    @Column
    private int amount;
    @ManyToOne
    @JoinColumn(name = "payerAccount")
    private BankAccount payerAccount;

    public Payment(String beneficiary, String beneficiaryAccountNumber, String reason, String reasonCode, String status, int amount, BankAccount payerAccount) {
        this.beneficiary = beneficiary;
        this.beneficiaryAccountNumber = beneficiaryAccountNumber;
        this.reason = reason;
        this.reasonCode = reasonCode;
        this.status = status;
        this.amount = amount;
        this.payerAccount = payerAccount;
    }
}
