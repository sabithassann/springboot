package com.sabit.nexchain.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "procurement")
public class Procurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "procurement_id")
    private Long procurementID;

    @ManyToOne
    @JoinColumn(name = "supplier_id")
    private Supplier supplier;


    @ManyToOne
    @JoinColumn(name = "material_id")
    private RawMaterial rawMaterial;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unit_price")
    private double unitPrice;

    @Column(name = "total_price")
    private double totalPrice;

    @Column(name = "procurement_date")
    private Date procurementDate;

//    @ManyToOne
//    @JoinColumn(name = "employee_id")
//    private Employee employee;




}
