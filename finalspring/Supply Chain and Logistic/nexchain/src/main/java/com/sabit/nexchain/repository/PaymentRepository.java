package com.sabit.nexchain.repository;

import com.sabit.nexchain.model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentRepository extends JpaRepository<Payment, Long> {
}
