package com.sabit.nexchain.model.production;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "recipe_id")
    private Long recipeId;


    @ManyToOne
    @JoinColumn(name = "product_id")
    private ProductionProduct product;


    @OneToMany(mappedBy = "recipe", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonBackReference
//    @JsonIgnore // Add this annotation to break the infinite loop
    private List<Ingredient> ingredients = new ArrayList<>();
}
