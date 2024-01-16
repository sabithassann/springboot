package com.sabit.nexchain.controller;

import com.sabit.nexchain.model.Procurement;
import com.sabit.nexchain.repository.ProcurementRepository;
import com.sabit.nexchain.repository.RawMaterialRepository;
import com.sabit.nexchain.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@Controller
public class ProcurementController {
    @Autowired
    private ProcurementRepository procurementRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private RawMaterialRepository rawMaterialRepository;

    @GetMapping("/procurement-form")
    public String showProcurementForm(Model model) {
        model.addAttribute("procurement", new Procurement());
        model.addAttribute("suppliers", supplierRepository.findAll());
        model.addAttribute("materials", rawMaterialRepository.findAll());
        return "procurement-form";
    }

    @PostMapping("/saveProcurement")
    public String saveProcurement( @ModelAttribute Procurement procurement) {
//        if (result.hasErrors()) {
////            model.addAttribute("suppliers", supplierRepository.findAll());
////            model.addAttribute("materials", rawMaterialRepository.findAll());
//            return "procurement-form";
//        }
        procurementRepository.save(procurement);
        return "redirect:/procurement-form";
    }
}
