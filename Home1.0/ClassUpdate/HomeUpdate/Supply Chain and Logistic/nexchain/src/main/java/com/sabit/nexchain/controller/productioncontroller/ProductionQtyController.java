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
    public ResponseEntity<String> produceAppleJuice(@RequestBody int numberOfBottles){

        try {
            productionService.produceAppleJuice(numberOfBottles);
            return new ResponseEntity<>("Apple juice production successfully", HttpStatus.OK);

        }catch (Exception e) {
            return new ResponseEntity<>("Error occurred while producing apple juice: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/ingredients")
    public ResponseEntity<?> getProductIngredients(@RequestParam String productName) {
        try {
            // Retrieve the recipe based on the provided product name
            Recipe productRecipe = recipeRepository.findByProductProductName(productName);
            if (productRecipe == null) {
                return new ResponseEntity<>("Recipe not found for product: " + productName, HttpStatus.NOT_FOUND);
            }

            // Get the ingredients from the retrieved recipe
            List<Ingredient> ingredients = productRecipe.getIngredients();

            // Return the list of ingredients
            return new ResponseEntity<>(ingredients, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error occurred while fetching ingredients for product " + productName + ": " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
