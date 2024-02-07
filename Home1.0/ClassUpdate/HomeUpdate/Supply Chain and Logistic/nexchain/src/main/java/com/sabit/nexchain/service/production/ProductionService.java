package com.sabit.nexchain.service.production;


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
        // Step 1: Retrieve ingredients for apple juice recipe
        Recipe appleJuiceRecipe = getAppleJuiceRecipe();

        // Step 2: Calculate quantity needed for each ingredient
        List<Ingredient> ingredients = appleJuiceRecipe.getIngredients();
        Map<Ingredient, Integer> ingredientQuantitiesNeeded = calculateIngredientQuantities(ingredients, numberOfBottles);

        // Step 3: Update stock levels
        updateStockLevels(ingredientQuantitiesNeeded);

        // Step 4: Persist changes (update stock levels in the database)
        saveUpdatedStockLevels(ingredientQuantitiesNeeded);
    }

    private Recipe getAppleJuiceRecipe() {
        // Logic to retrieve the apple juice recipe from the database (e.g., using a repository)
        // For demonstration purposes, let's assume the recipe is fetched from the database
        // You should implement this method according to your database access mechanism
        // For example:
         return recipeRepository.findByProductProductName("Apple Juice");

    }

    private Map<Ingredient, Integer> calculateIngredientQuantities(List<Ingredient> ingredients, int numberOfBottles) {
        // Logic to calculate the quantity needed for each ingredient based on the recipe and number of bottles
        Map<Ingredient, Integer> ingredientQuantitiesNeeded = new HashMap<>();
        for (Ingredient ingredient : ingredients) {
            int quantityNeeded = ingredient.getQuantity() * numberOfBottles;
            ingredientQuantitiesNeeded.put(ingredient, quantityNeeded);
        }
        return ingredientQuantitiesNeeded;
    }

    private void updateStockLevels(Map<Ingredient, Integer> ingredientQuantitiesNeeded) {
        // Logic to deduct the calculated quantities from the stock levels of each ingredient
        for (Map.Entry<Ingredient, Integer> entry : ingredientQuantitiesNeeded.entrySet()) {
            Ingredient ingredient = entry.getKey();
            int quantityNeeded = entry.getValue();

            Stock stock = ingredient.getStock();
            int currentQuantity = stock.getQuantity();
            stock.setQuantity(currentQuantity - quantityNeeded);
        }
    }

    private void saveUpdatedStockLevels(Map<Ingredient, Integer> ingredientQuantitiesNeeded) {
        // Logic to persist the updated stock levels in the database
        for (Map.Entry<Ingredient, Integer> entry : ingredientQuantitiesNeeded.entrySet()) {
            Ingredient ingredient = entry.getKey();
            Stock stock = ingredient.getStock();
            stockRepository.save(stock);
        }
    }
}
