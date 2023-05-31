package com.jazzybruno.example.v1.repositories;

import com.jazzybruno.example.v1.models.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
}