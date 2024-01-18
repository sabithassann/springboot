package com.sabit.nexchain.controller;


import com.sabit.nexchain.model.Inventory;
import com.sabit.nexchain.model.Procurement;
import com.sabit.nexchain.model.RawMaterial;
import com.sabit.nexchain.repository.InventoryRepository;
import com.sabit.nexchain.repository.ProcurementRepository;
import com.sabit.nexchain.repository.RawMaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Controller
public class InventoryController {

    @Autowired
    private InventoryRepository inventoryRepository;


    @Autowired
    private RawMaterialRepository rawMaterialRepository;


    @Autowired
    private ProcurementRepository procurementRepository;


    @GetMapping("/inventory-form")
    public  String showInventoryForm(Model model){
        List<RawMaterial> rawMaterials=rawMaterialRepository.findAll();
        model.addAttribute("rawMaterials", rawMaterials);
        model.addAttribute("inventory", new Inventory());
        return "inventory-form";
    }

//    @PostMapping("/saveInventory")
//    public String saveInventory(@ModelAttribute Inventory inventory){
//        inventoryRepository.save(inventory);
//        return "redirect:/inventory-form";
//    }


//    @PostMapping("saveInventory")
//    public String saveInventory(@ModelAttribute Inventory inventory, Model model){
//        Long procurementId=inventory.getProcurementId();
//
//        Optional<Inventory> existingInventory=inventoryRepository.findByProcurementId(procurementId);
//
//    if (existingInventory.isPresent()){
//        model.addAttribute("message", "Inventory form Procurement Id "+ procurementId+ " already exists");
//        return "inventory-form";
//    }
//    inventoryRepository.save(inventory);
//
//    return "redirect:/inventory-form";
//    }



    @GetMapping("/getProcurementData")
    public String getProcurementData(@RequestParam Long procurementId, Model model){
        Procurement procurement=procurementRepository.findById(procurementId).orElse(null);


        if (procurement !=null){
            model.addAttribute("materialId", procurement.getRawMaterial().getMaterialID());
            model.addAttribute("quantity",procurement.getQuantity());
        } else {
            model.addAttribute("materialId", "");
            model.addAttribute("quantity", "");
        }

        return "inventory-form :: procurement-data";

    }


    @PostMapping("/saveInventory")
    public String saveInventory(Inventory inventory, Model model){
        Long procurementId = inventory.getProcurementId();

        if (inventoryRepository.existsById(procurementId)){

            model.addAttribute("message","Inventory for Procurement Id "+ procurementId + " Is Exists");
            return "inventory-form";

        }

        inventoryRepository.save(inventory);
        return "redirect:/inventory-form";
    }

}
