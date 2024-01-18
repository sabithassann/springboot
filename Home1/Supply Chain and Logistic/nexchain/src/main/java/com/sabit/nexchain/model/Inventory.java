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

    @Column(name = "procurement_id")
    private Long procurementId;

//    @ManyToOne
//    @JoinColumn(name = "procurement_id")
//    private Procurement procurement;
}
