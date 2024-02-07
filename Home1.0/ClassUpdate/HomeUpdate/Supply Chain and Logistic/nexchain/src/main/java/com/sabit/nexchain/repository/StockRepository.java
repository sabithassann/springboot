package com.sabit.nexchain.repository;


import com.sabit.nexchain.model.RawMaterial;
import com.sabit.nexchain.model.Stock;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StockRepository extends JpaRepository<Stock ,Long> {
    Stock findByRawMaterial(RawMaterial rawMaterial);
}
