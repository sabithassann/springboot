package com.sabit.nexchain.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "payment")
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "payment_id")
    private Long paymentID;

    @ManyToOne
    @JoinColumn(name = "procurement_id")
    private Procurement procurement;

    @Column(name = "payment_account")
    private String paymentAccount;

    @Column(name = "payment_amount")
    private double paymentAmount;

    @Column(name = "payment_date")
    private Date paymentDate;
}
