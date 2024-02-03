package com.sabit.nexchain.repository.production;

import com.sabit.nexchain.model.product.ProductionRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductionRecordRepository extends JpaRepository<ProductionRecord ,Long> {
}
