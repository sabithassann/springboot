package com.sabit.nexchain.model;


import lombok.Data;

@Data
public class InventoryDetailsDTO {
    private Long material_id;
    private String material_name;
    private String material_type;
    private int totalQuantityInInventory;


    public InventoryDetailsDTO(Long material_id, String material_name, String material_type, int totalQuantityInInventory) {
        this.material_id = material_id;
        this.material_name = material_name;
        this.material_type = material_type;
        this.totalQuantityInInventory = totalQuantityInInventory;
    }
}
