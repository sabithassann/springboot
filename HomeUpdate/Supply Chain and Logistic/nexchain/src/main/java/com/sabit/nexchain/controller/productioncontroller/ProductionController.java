package com.sabit.nexchain.controller.productioncontroller;


import com.sabit.nexchain.model.product.Product;
import com.sabit.nexchain.model.product.ProductionRecord;
import com.sabit.nexchain.repository.production.ProductRepository;
import com.sabit.nexchain.repository.production.ProductionRecordRepository;
import com.sabit.nexchain.service.InventoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductionController {
    @Autowired
    private InventoryService inventoryService;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private ProductionRecordRepository productionRecordRepository;



    @PostMapping("/placeOrder")
    public ResponseEntity<String> placeProductionOrder(@RequestParam Long productId, @RequestParam int quantity) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new RuntimeException("Product not found"));

        ProductionRecord productionOrder = new ProductionRecord();
        productionOrder.setProduct(product);
        productionOrder.setProductionQuantity(quantity);

        inventoryService.updateInventoryForProduction(product, quantity);
        productionRecordRepository.save(productionOrder);

        return ResponseEntity.ok("Production order placed successfully.");
    }

}
