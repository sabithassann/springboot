package com.sabit.nexchain.controller;


import com.sabit.nexchain.model.Payment;
import com.sabit.nexchain.model.Procurement;
import com.sabit.nexchain.repository.PaymentRepository;

import com.sabit.nexchain.repository.ProcurementRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class PaymentController {

    @Autowired
    private PaymentRepository paymentRepository;

    @Autowired
    private ProcurementRepository procurementRepository;


    @GetMapping("/payment-form")
    public String showPaymentForm(Model model){
        List<Procurement> procurements=procurementRepository.findAll();
        model.addAttribute("procurements", procurements);
        model.addAttribute("payment", new Payment());
        return "payment-form";

    }


    @PostMapping("/savePayment")
    public String savePayment(@ModelAttribute Payment payment){

        paymentRepository.save(payment);
        return "redirect:/payment-form";

    }
}
