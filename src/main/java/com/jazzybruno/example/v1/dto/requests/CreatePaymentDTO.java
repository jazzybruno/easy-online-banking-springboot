package com.jazzybruno.example.v1.dto.requests;

import com.jazzybruno.example.v1.models.BankAccount;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreatePaymentDTO {
    private String  beneficiary;
    private String beneficiaryAccountNumber;
    private String reason;
    private String reasonCode;
    private String status;
    private int amount;
    private Long payerAccountId;
}
