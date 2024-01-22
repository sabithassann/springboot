package com.sabit.nexchain.service;


import com.sabit.nexchain.model.Inventory;
import com.sabit.nexchain.model.InventoryDetailsDTO;
import com.sabit.nexchain.model.product.Product;
import com.sabit.nexchain.repository.InventoryRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import org.hibernate.query.NativeQuery;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class InventoryService {


    @Autowired
    private  InventoryRepository inventoryRepository;


//    @PersistenceContext
//    private EntityManager entityManager;

//    @Autowired
//    private  EntityManager entityManager;



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





//    @Transactional(readOnly = true)
//    public List<Inventory> getInventoryDetails() {
//        // Execute the SQL query to get inventory details
//        Query query = entityManager.createNativeQuery(
//                "SELECT " +
//                        "rm.material_id, " +
//                        "rm.material_name, " +
//                        "rm.material_type, " +
//                        "COALESCE(SUM(inv.quantity_in_stock), 0) AS TotalQuantityInInventory " +
//                        "FROM raw_material rm " +
//                        "LEFT JOIN inventory inv ON rm.material_id = inv.material_id " +
//                        "GROUP BY rm.material_id, rm.material_name, rm.material_type",
//                "InventoryDetailsMapping" // Assuming you have a mapping for the result
//        );
//
//        // Fetch the result list
//        return query.getResultList();
//    }

//    @Transactional(readOnly = true)
//    public List<Inventory> getInventoryDetails() {
//        // Your implementation to get inventory details
//    }


//    @Transactional(readOnly = true)
//public List<InventoryDetailsDTO> getInventoryDetails() {
//    String sqlQuery = "SELECT " +
//            "rm.material_id as materialId, " +
//            "rm.material_name as materialName, " +
//            "rm.material_type as materialType, " +
//            "COALESCE(SUM(inv.quantity_in_stock), 0) AS totalQuantityInInventory " +
//            "FROM raw_material rm " +
//            "LEFT JOIN inventory inv ON rm.material_id = inv.material_id " +
//            "GROUP BY rm.material_id, rm.material_name, rm.material_type";
//
//    Query query = entityManager.createNativeQuery(sqlQuery);
//    query.unwrap(org.hibernate.query.NativeQuery.class)
//            .setResultTransformer(Transformers.aliasToBean(InventoryDetailsDTO.class));
//
//    return query.getResultList();
//}


}
