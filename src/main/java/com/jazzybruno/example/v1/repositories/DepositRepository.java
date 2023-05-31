


package com.jazzybruno.example.v1.repositories;

import com.jazzybruno.example.v1.models.Deposit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepositRepository extends JpaRepository<Deposit, Long> {
}