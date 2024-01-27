package com.sabit.nexchain.service;


import com.sabit.nexchain.model.Inventory;
import com.sabit.nexchain.model.product.Product;
import com.sabit.nexchain.repository.InventoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Map;
import java.util.Optional;

@Service
public class InventoryService {


    @Autowired
    private  InventoryRepository inventoryRepository;

    @Transactional

    public void updateInventoryForProduction(Product product, int productionQuantity) {
        Map<String, Integer> requiredMaterials = product.getRecipe();

        for (Map.Entry<String, Integer> entry : requiredMaterials.entrySet()) {
            updateInventory(entry.getKey(), entry.getValue() * productionQuantity);
        }
    }

    private void updateInventory(String materialName, int quantity) {
        Inventory inventoryEntry = inventoryRepository.findByRawMaterial_MaterialName(materialName);

        int currentQuantity = inventoryEntry.getQuantityInStock();
        inventoryEntry.setQuantityInStock(currentQuantity - quantity);
        inventoryEntry.setLastStockUpdateDate(Date.valueOf(LocalDate.now()));

        inventoryRepository.save(inventoryEntry);
    }

}
