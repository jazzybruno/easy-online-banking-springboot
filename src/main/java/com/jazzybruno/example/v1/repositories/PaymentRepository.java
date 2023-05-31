package com.jazzybruno.example.v1.repositories;

import com.jazzybruno.example.v1.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}