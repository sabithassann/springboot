package com.sabit.nexchain.model;


import jakarta.persistence.*;
import lombok.Data;

import java.sql.Date;


@Data
@Entity
@Table(name = "inventory")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Long inventoryID;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private RawMaterial rawMaterial;

    @Column(name = "quantity_in_stock")
    private int quantityInStock;

    @Column(name = "last_stock_update_date")
    private Date lastStockUpdateDate;



    @ManyToOne
    @JoinColumn(name = "procurement_id")
    private Procurement procurement;



    // Constructor for native query result mapping


    public Inventory(Long inventoryID, RawMaterial rawMaterial, int quantityInStock, Date lastStockUpdateDate, Procurement procurement) {
        this.inventoryID = inventoryID;
        this.rawMaterial = rawMaterial;
        this.quantityInStock = quantityInStock;
        this.lastStockUpdateDate = lastStockUpdateDate;
        this.procurement = procurement;
    }


    public Inventory() {

    }
}
