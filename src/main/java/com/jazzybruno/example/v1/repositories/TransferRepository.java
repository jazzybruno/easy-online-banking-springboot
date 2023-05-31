package com.jazzybruno.example.v1.repositories;

import com.jazzybruno.example.v1.models.Transfer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransferRepository extends JpaRepository<Transfer, Long> {
}