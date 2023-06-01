package com.jazzybruno.example.v1.services;

import com.jazzybruno.example.v1.dto.requests.CreateBankAccountDTO;
import com.jazzybruno.example.v1.dto.requests.UpdateBankAccountDTO;
import com.jazzybruno.example.v1.payload.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface BankAccountService {
  public ResponseEntity<ApiResponse> getAllBankAccounts();
  public ResponseEntity<ApiResponse> getBankAccountById(Long accountId);
  public ResponseEntity<ApiResponse> createBankAccount(CreateBankAccountDTO createBankAccountDTO);
  public ResponseEntity<ApiResponse> updateBankAccount(Long accountId , UpdateBankAccountDTO updateBankAccountDTO);
  public ResponseEntity<ApiResponse> deleteBankAccount(Long accountId);
}
