package com.sabit.nexchain.service;


import com.sabit.nexchain.model.Payment;
import com.sabit.nexchain.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment getPaymentById(Long paymentID){
        return paymentRepository.findById(paymentID).orElse(null);

    }
}
