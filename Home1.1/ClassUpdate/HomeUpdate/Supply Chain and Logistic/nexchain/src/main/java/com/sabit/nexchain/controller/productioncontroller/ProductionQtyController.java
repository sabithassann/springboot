package com.sabit.nexchain.controller.productioncontroller;


import com.sabit.nexchain.model.production.Ingredient;
import com.sabit.nexchain.model.production.Recipe;
import com.sabit.nexchain.repository.production.RecipeRepository;
import com.sabit.nexchain.service.production.ProductionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/production")
public class ProductionQtyController {

//    http://localhost:8084/production/ingredients?productName=Apple Juice

    @Autowired
    private ProductionService productionService;

    @Autowired
    private RecipeRepository  recipeRepository;

    @PostMapping("/produceAppleJuice")
    public ResponseEntity<String> produceAppleJuice(@RequestParam int numberOfBottles) {
        try {
            productionService.produceAppleJuice(numberOfBottles);
            return ResponseEntity.ok("Apple juice production successful");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("Error producing apple juice: " + e.getMessage());
        }
    }


}
