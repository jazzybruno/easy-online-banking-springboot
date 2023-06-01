package com.jazzybruno.example.v1.controllers;

import com.jazzybruno.example.v1.dto.requests.CreateBankAccountDTO;
import com.jazzybruno.example.v1.dto.requests.UpdateBankAccountDTO;
import com.jazzybruno.example.v1.payload.ApiResponse;
import com.jazzybruno.example.v1.serviceImpls.BankAccountServiceImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/banks")
public class BankAccountController {
    private final BankAccountServiceImpl bankAccountService;
    @GetMapping
    public ResponseEntity<ApiResponse> getAllBankAccounts() {
        return bankAccountService.getAllBankAccounts();
    }

    @GetMapping("/id/{accountId")
    public ResponseEntity<ApiResponse> getBankAccountById(@PathVariable Long accountId) {
        return bankAccountService.getBankAccountById(accountId);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createBankAccount(@RequestBody CreateBankAccountDTO createBankAccountDTO) {
        return bankAccountService.createBankAccount(createBankAccountDTO);
    }

    @PutMapping("/update/{accountId}")
    public ResponseEntity<ApiResponse> updateBankAccount(@PathVariable Long accountId, @RequestBody UpdateBankAccountDTO updateBankAccountDTO) {
        return bankAccountService.updateBankAccount(accountId , updateBankAccountDTO);
    }

    @DeleteMapping("/delete/{accountId}")
    public ResponseEntity<ApiResponse> deleteBankAccount(@PathVariable Long accountId) {
        return bankAccountService.deleteBankAccount(accountId);
    }
}
