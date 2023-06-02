package com.jazzybruno.example.v1.serviceImpls;

import com.jazzybruno.example.v1.dto.requests.CreatePaymentDTO;
import com.jazzybruno.example.v1.models.BankAccount;
import com.jazzybruno.example.v1.models.Payment;
import com.jazzybruno.example.v1.payload.ApiResponse;
import com.jazzybruno.example.v1.repositories.BankAccountRepository;
import com.jazzybruno.example.v1.repositories.PaymentRepository;
import com.jazzybruno.example.v1.services.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PaymentServiceImpl implements PaymentService {
    private final PaymentRepository paymentRepository;
    private final BankAccountRepository bankAccountRepository;

    @Override
    public ResponseEntity<ApiResponse> getAllPayments() {
        try {
            List<Payment> paymentList = paymentRepository.findAll();
            return ResponseEntity.ok().body(
                    new ApiResponse(
                            true ,
                            "Successfully fetched all payments",
                            paymentList
                    )
            );
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ApiResponse(
                            false ,
                            "Failed to fetch all payments"
                    )
            );
        }
    }

    @Override
    public ResponseEntity<ApiResponse> getPaymentById(Long paymentId) {
        try {
            Optional<Payment> optionalPayment = paymentRepository.findById(paymentId);
            if(optionalPayment.isPresent()){
                   Payment payment = optionalPayment.get();
                   return ResponseEntity.ok().body(
                           new ApiResponse(
                                   true,
                                   "Successfully fetched the payment with id: " + paymentId,
                                   payment
                           )
                   );
            }else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new ApiResponse(
                                false ,
                                "The payment with id: " + paymentId +" does not exist"
                        )
                );
            }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ApiResponse(
                            false ,
                            "Failed to fetch all payments"
                    )
            );
        }
    }

    @Override
    @Transactional
    public ResponseEntity<ApiResponse> createPayment(CreatePaymentDTO createPaymentDTO) {
        try {
           Optional<BankAccount> optionalBankAccount = bankAccountRepository.findById(createPaymentDTO.getPayerAccountId());
           if(optionalBankAccount.isPresent()){
               BankAccount bankAccount = optionalBankAccount.get();
               int balance = bankAccount.getAccountBalance() - createPaymentDTO.getAmount();
               bankAccount.setAccountBalance(balance);
               Payment payment = new Payment(
                       createPaymentDTO.getBeneficiary(),
                       createPaymentDTO.getBeneficiaryAccountNumber(),
                       createPaymentDTO.getReason(),
                       createPaymentDTO.getReasonCode(),
                       createPaymentDTO.getStatus(),
                       createPaymentDTO.getAmount(),
                       bankAccount
               );
               paymentRepository.save(payment);
               return ResponseEntity.ok().body(
                       new ApiResponse(
                               true,
                               "Successfully created the payment",
                               payment
                       )
               );
           }else {
               return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                       new ApiResponse(
                               false ,
                               "The bank account with id: " + createPaymentDTO.getPayerAccountId() +" does not exist"
                       )
               );
           }
        }catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(
                    new ApiResponse(
                            false ,
                            "Failed to fetch all payments"
                    )
            );
        }
    }
}
