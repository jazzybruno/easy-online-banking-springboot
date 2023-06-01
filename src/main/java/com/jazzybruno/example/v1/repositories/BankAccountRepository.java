package com.jazzybruno.example.v1.repositories;

import com.jazzybruno.example.v1.models.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
    Optional<BankAccount> findBankAccountByAccountName(String accountName);
    Optional<BankAccount> findBankAccountByAccountNumber(String accountNumber);
}