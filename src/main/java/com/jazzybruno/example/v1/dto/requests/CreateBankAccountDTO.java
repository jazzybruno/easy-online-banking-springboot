package com.jazzybruno.example.v1.dto.requests;

import com.jazzybruno.example.v1.enums.BankAccountType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CreateBankAccountDTO {
    private String accountName;
    private BankAccountType bankAccountType;
}
