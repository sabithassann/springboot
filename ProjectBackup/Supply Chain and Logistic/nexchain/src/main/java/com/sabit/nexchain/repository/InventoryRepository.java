package com.sabit.nexchain.repository;

import com.sabit.nexchain.model.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
}
