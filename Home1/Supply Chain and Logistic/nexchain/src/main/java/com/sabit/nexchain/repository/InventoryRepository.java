package com.sabit.nexchain.repository;

import com.sabit.nexchain.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {

    Optional<Inventory> findByProcurementId(Long procurementId);
}
