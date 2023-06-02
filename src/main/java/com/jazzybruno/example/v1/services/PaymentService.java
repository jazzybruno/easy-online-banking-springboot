package com.jazzybruno.example.v1.services;

import com.jazzybruno.example.v1.dto.requests.CreatePaymentDTO;
import com.jazzybruno.example.v1.payload.ApiResponse;
import org.springframework.http.ResponseEntity;

public interface PaymentService {
    public ResponseEntity<ApiResponse> getAllPayments();
    public ResponseEntity<ApiResponse> getPaymentById(Long paymentId);
    public ResponseEntity<ApiResponse> createPayment(CreatePaymentDTO createPaymentDTO);
}
