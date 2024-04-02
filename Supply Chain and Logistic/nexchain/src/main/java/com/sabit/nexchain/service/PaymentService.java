package com.sabit.nexchain.service;


import com.sabit.nexchain.model.Payment;
import com.sabit.nexchain.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment getPaymentById(Long paymentID){
        return paymentRepository.findById(paymentID).orElse(null);

    }

    public ResponseEntity<List<Payment>> getAllPayments(){
        List<Payment> paymentList=paymentRepository.findAll();
        if (paymentList.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(paymentList,HttpStatus.OK);
    }
}
