package com.sabit.nexchain.restcontroller;


import com.sabit.nexchain.model.Supplier;
import com.sabit.nexchain.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/supplier")
public class SupplierRestController {

    @Autowired
    private SupplierRepository supplierRepository;

    @GetMapping
    public List<Supplier> getAllSupplier(){
        return supplierRepository.findAll();
    }

    @PostMapping
    public Supplier saveSupplier(@RequestBody Supplier supplier){
        return supplierRepository.save(supplier);
    }

    @DeleteMapping("/{id}")
    public void deleteSupplier(@PathVariable Long id){
        supplierRepository.deleteById(id);

    }
}
