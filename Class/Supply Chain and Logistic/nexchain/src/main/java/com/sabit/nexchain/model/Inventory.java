package com.sabit.nexchain.model;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Table(name = "inventory")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "inventory_id")
    private Long inventoryId;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private RawMaterial rawMaterial;

    @Column(name = "quantity_in_stock")
    private int quantityInStock;

    @Column(name = "last_stock_update_date")
    private Date lastStockUpdateDate;
}
