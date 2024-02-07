package com.sabit.nexchain.service.production;


import com.sabit.nexchain.model.RawMaterial;
import com.sabit.nexchain.model.production.Ingredient;
import com.sabit.nexchain.model.production.Recipe;
import com.sabit.nexchain.repository.RawMaterialRepository;
import com.sabit.nexchain.repository.production.RecipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecipeService {
    @Autowired
    private RecipeRepository recipeRepository;

    @Autowired
    private RawMaterialRepository rawMaterialRepository;

    public List<Recipe> getAllRecipes() {
        return recipeRepository.findAll();
    }

    public Recipe createRecipe(Recipe recipe) {
//        // Iterate through the ingredients
//        for (Ingredient ingredient : recipe.getIngredients()) {
//            // Check if the ingredient's recipe reference is already set
//            if (ingredient.getRecipe() == null || !ingredient.getRecipe().equals(recipe)) {
//                // Set the recipe reference for the ingredient only if it's not already set
//                ingredient.setRecipe(recipe);
//            }
//        }
//        return recipeRepository.save(recipe);



        for (Ingredient ingredient : recipe.getIngredients()) {
// Fetch the RawMaterial object based on the material name
            String materialName = ingredient.getName();
            RawMaterial rawMaterial = rawMaterialRepository.findByMaterialName(materialName);
            if (rawMaterial == null) {
                // Handle the case when material is not found
                throw new IllegalArgumentException("RawMaterial with name " + materialName + " not found");
            }
            // Set the fetched RawMaterial object in the Ingredient
            ingredient.setRawMaterial(rawMaterial);
            ingredient.setRecipe(recipe);
        }
        return recipeRepository.save(recipe);
    }

    public Recipe getRecipeById(Long id) {
        return recipeRepository.findById(id).orElse(null);
    }

    public void deleteRecipe(Long id) {
        recipeRepository.deleteById(id);
    }
}