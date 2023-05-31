package com.jazzybruno.example.v1.repositories;

import com.jazzybruno.example.v1.models.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, Long> {
}