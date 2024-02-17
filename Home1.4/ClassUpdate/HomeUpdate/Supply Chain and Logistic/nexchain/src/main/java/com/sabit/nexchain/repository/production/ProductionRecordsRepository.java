package com.sabit.nexchain.repository.production;

import com.sabit.nexchain.model.production.ProductionRecords;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionRecordsRepository extends JpaRepository<ProductionRecords,Long> {
}
