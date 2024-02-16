package com.sabit.nexchain.service.production;


import com.sabit.nexchain.model.RawMaterial;
import com.sabit.nexchain.model.Stock;
import com.sabit.nexchain.model.production.Ingredient;
import com.sabit.nexchain.model.production.Recipe;
import com.sabit.nexchain.repository.StockRepository;
import com.sabit.nexchain.repository.production.IngredientRepository;
import com.sabit.nexchain.repository.production.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProductionService {


    @Autowired
    private IngredientRepository ingredientRepository;


    @Autowired
    private StockRepository stockRepository;


    @Autowired
    private RecipeRepository recipeRepository;






    public void produceAppleJuice(int numberOfBottles) {
        // Step 1: Retrieve the recipe for apple juice
        Recipe appleJuiceRecipe = recipeRepository.findByProductProductName("Watermelon Juice");

        // Step 2: Deduct ingredient quantities from stock
        List<Ingredient> ingredients = appleJuiceRecipe.getIngredients();
        Map<String, Boolean> ingredientStatus = new HashMap<>(); // Map to track ingredient status

        for (Ingredient ingredient : ingredients) {
            String ingredientName = ingredient.getName(); // Assuming name corresponds to material_id
            Stock stock = stockRepository.findByRawMaterial_MaterialName(ingredientName); // Fetch stock by raw material name
            if (stock != null) {
                int quantityNeeded = ingredient.getQuantity() * numberOfBottles;
                int currentQuantity = stock.getQuantity();
                if (currentQuantity >= quantityNeeded) {
                    stock.setQuantity(currentQuantity - quantityNeeded);
                    stockRepository.save(stock);
                    // Log ingredient as found in stock
                    System.out.println("Found ingredient in stock: " + ingredientName);
                    ingredientStatus.put(ingredientName, true); // Mark ingredient as found
                } else {
                    // Log ingredient as not found in sufficient quantity
                    System.out.println("Ingredient not found in sufficient quantity: " + ingredientName);
                    ingredientStatus.put(ingredientName, false); // Mark ingredient as not found
                }
            } else {
                // Handle case where stock is not found for the ingredient
                System.out.println("Stock not found for Ingredient: " + ingredientName);
                ingredientStatus.put(ingredientName, false); // Mark ingredient as not found
            }
        }

        // Print summary of ingredient status
        System.out.println("Ingredient Status:");
        for (Map.Entry<String, Boolean> entry : ingredientStatus.entrySet()) {
            System.out.println(entry.getKey() + ": " + (entry.getValue() ? "Found" : "Not Found"));
        }
    }

//    public void produceAppleJuice(int numberOfBottles) {
//        // Step 1: Retrieve the recipe for apple juice
//        Recipe appleJuiceRecipe = recipeRepository.findByProductProductName("Watermelon Juice");
//
//        // Step 2: Deduct ingredient quantities from stock
//        List<Ingredient> ingredients = appleJuiceRecipe.getIngredients();
//        for (Ingredient ingredient : ingredients) {
//            Stock stock = ingredient.getStock();
//            if (stock != null) {
//                int quantityNeeded = ingredient.getQuantity() * numberOfBottles;
//                int currentQuantity = stock.getQuantity();
//                stock.setQuantity(currentQuantity - quantityNeeded);
//                stockRepository.save(stock);
//            } else {
//                // Handle case where stock is not found for the ingredient
//                throw new RuntimeException("Stock not found for Ingredient: " + ingredient.getName());
//            }
//        }
//    }




//    public void produceAppleJuice(int numberOfBottles) {
//        // Step 1: Retrieve ingredients for apple juice recipe
//        Recipe appleJuiceRecipe = getAppleJuiceRecipe();
//
//        // Step 2: Calculate quantity needed for each ingredient
//        List<Ingredient> ingredients = appleJuiceRecipe.getIngredients();
//        Map<Ingredient, Integer> ingredientQuantitiesNeeded = calculateIngredientQuantities(ingredients, numberOfBottles);
//
//        // Step 3: Update stock levels
//        updateStockLevels(ingredientQuantitiesNeeded);
//
//        // Step 4: Persist changes (update stock levels in the database)
//        saveUpdatedStockLevels(ingredientQuantitiesNeeded);
//    }
//
//    private Recipe getAppleJuiceRecipe() {
//
//        return recipeRepository.findByProductProductName("Banana Juice");
//
//    }
//
//    private Map<Ingredient, Integer> calculateIngredientQuantities(List<Ingredient> ingredients, int numberOfBottles) {
//        // Logic to calculate the quantity needed for each ingredient based on the recipe and number of bottles
//        Map<Ingredient, Integer> ingredientQuantitiesNeeded = new HashMap<>();
//        for (Ingredient ingredient : ingredients) {
//            int quantityNeeded = ingredient.getQuantity() * numberOfBottles;
//            ingredientQuantitiesNeeded.put(ingredient, quantityNeeded);
//        }
//        return ingredientQuantitiesNeeded;
//    }
//
//    private void updateStockLevels(Map<Ingredient, Integer> ingredientQuantitiesNeeded) {
//        for (Map.Entry<Ingredient, Integer> entry : ingredientQuantitiesNeeded.entrySet()) {
//            Ingredient ingredient = entry.getKey();
//            int quantityNeeded = entry.getValue();
//
//            Stock stock = ingredient.getStock();
//            if (stock == null) {
//                // This assumes Ingredient has a direct relationship with Stock
//                // If not, you might need to adjust this logic accordingly
//                throw new IllegalArgumentException("Stock not found for Ingredient: " + ingredient.getName());
//            }
//
//            int currentQuantity = stock.getQuantity();
//            stock.setQuantity(currentQuantity - quantityNeeded);
//            stockRepository.save(stock);
//        }
//    }
//
//    private void saveUpdatedStockLevels(Map<Ingredient, Integer> ingredientQuantitiesNeeded) {
//        // Logic to persist the updated stock levels in the database
//        for (Map.Entry<Ingredient, Integer> entry : ingredientQuantitiesNeeded.entrySet()) {
//            Ingredient ingredient = entry.getKey();
//            Stock stock = ingredient.getStock();
//            stockRepository.save(stock);
//        }
//    }
}
