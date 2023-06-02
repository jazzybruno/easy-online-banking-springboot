package com.jazzybruno.example.v1.controllers;

import com.jazzybruno.example.v1.dto.requests.CreatePaymentDTO;
import com.jazzybruno.example.v1.payload.ApiResponse;
import com.jazzybruno.example.v1.serviceImpls.PaymentServiceImpl;
import com.jazzybruno.example.v1.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payments")
public class PaymentController {

    private final PaymentServiceImpl paymentService;

    @GetMapping
    public ResponseEntity<ApiResponse> getAllPayments() {
        return paymentService.getAllPayments();
    }

    @GetMapping("/id/{paymentId}")
    public ResponseEntity<ApiResponse> getPaymentById(@PathVariable Long paymentId) {
        return paymentService.getPaymentById(paymentId);
    }

    @PostMapping("/create")
    public ResponseEntity<ApiResponse> createPayment(@RequestBody CreatePaymentDTO createPaymentDTO) {
        return paymentService.createPayment(createPaymentDTO);
    }
}
