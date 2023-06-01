package com.jazzybruno.example.v1.serviceImpls;

import com.jazzybruno.example.v1.dto.requests.CreateBankAccountDTO;
import com.jazzybruno.example.v1.dto.requests.UpdateBankAccountDTO;
import com.jazzybruno.example.v1.models.BankAccount;
import com.jazzybruno.example.v1.payload.ApiResponse;
import com.jazzybruno.example.v1.repositories.BankAccountRepository;
import com.jazzybruno.example.v1.services.BankAccountService;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BankAccountServiceImpl implements BankAccountService {
    private final BankAccountRepository bankAccountRepository;
    @Override
    public ResponseEntity<ApiResponse> getAllBankAccounts() {
        try {
            List<BankAccount> bankAccounts = bankAccountRepository.findAll();
            return ResponseEntity.ok().body(
                    new ApiResponse(
                            true,
                            "Successfully fetched all the bank accounts",
                            bankAccounts
                    )
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ApiResponse(
                            false,
                            "Failed to fetch the bank accounts"
                    )
            );
        }
    }

    @Override
    public ResponseEntity<ApiResponse> getBankAccountById(Long accountId) {
       try {
           Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(accountId);
           if(optionalBankAccount.isPresent()){
               return ResponseEntity.ok().body(
                       new ApiResponse(
                               true,
                               "Successfully retrieved the bank account with id: " + accountId,
                               optionalBankAccount.get()
                       )
               );
           }else {
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                       new ApiResponse(
                               false,
                               "The bank account with id: " + accountId + " was not found"
                       )
               );
           }
       }catch (Exception e){
           return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                   new ApiResponse(
                           false,
                           "Failed to fetch the bank accounts"
                   )
           );
       }
    }

    @Override
    public ResponseEntity<ApiResponse> createBankAccount(CreateBankAccountDTO createBankAccountDTO) {
      try {
          Optional<BankAccount> optionalBankAccount = bankAccountRepository.findBankAccountByAccountName(createBankAccountDTO.getAccountName());
          if (optionalBankAccount.isPresent()){
              String accountNumber = RandomStringUtils.randomAlphanumeric(5);
              Optional<BankAccount> optionalBankAccount1 = bankAccountRepository.findBankAccountByAccountNumber(accountNumber);
              if(optionalBankAccount1.isPresent()){
                  BankAccount bankAccount = new BankAccount(
                          createBankAccountDTO.getAccountName(),
                          createBankAccountDTO.getBankAccountType(),
                          0,
                          accountNumber,
                          new Date()
                  );
                  bankAccountRepository.save(bankAccount);
                  return ResponseEntity.status(HttpStatus.OK).body(
                          new ApiResponse(
                                  true,
                                  "Successfully saved the bank account",
                                  bankAccount
                          )
                  );
              }else {
                  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                          new ApiResponse(
                                  false,
                                  "The bank account with the number: " + accountNumber + " already exists"
                          )
                  );
              }
          }else {
              return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                      new ApiResponse(
                              false,
                              "The bank account with the name: " + createBankAccountDTO.getAccountName() + " already exists"
                      )
              );
          }
      }catch (Exception e){
          return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                  new ApiResponse(
                          false,
                          "Failed to create the bank account"
                  )
          );
      }
    }


    @Override
    @Transactional
    public ResponseEntity<ApiResponse> updateBankAccount(Long accountId , UpdateBankAccountDTO updateBankAccountDTO) {
        try {
         Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(accountId);
         if(optionalBankAccount.isPresent()){
             BankAccount bankAccount = optionalBankAccount.get();
             bankAccount.setAccountName(updateBankAccountDTO.getAccountName());
             bankAccount.setBankAccountType(updateBankAccountDTO.getBankAccountType());
             return ResponseEntity.status(HttpStatus.OK).body(
                     new ApiResponse(
                             true,
                             "Successfully updated the bank account",
                             bankAccount
                     )
             );
         }else {
             return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                     new ApiResponse(
                             false,
                             "The bank account with id: " + accountId + " was not found"
                     )
             );
         }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ApiResponse(
                            false,
                            "Failed to update the bank account"
                    )
            );
        }
    }

    @Override
    public ResponseEntity<ApiResponse> deleteBankAccount(Long accountId) {
        try {
            Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(accountId);
            if(optionalBankAccount.isPresent()){
                BankAccount bankAccount = optionalBankAccount.get();
                bankAccountRepository.delete(bankAccount);
                return ResponseEntity.ok().body(
                        new ApiResponse(
                                true,
                                "Successfully deleted the bank account with id: " + accountId,
                                optionalBankAccount.get()
                        )
                );
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ApiResponse(
                                false,
                                "The bank account with id: " + accountId + " was not found"
                        )
                );
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ApiResponse(
                            false,
                            "Failed to delete the bank account"
                    )
            );
        }
    }
}
