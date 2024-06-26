package com.sabit.nexchain.model.production;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.sabit.nexchain.model.RawMaterial;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name =  "ingredient")
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ingredient_id")
    private Long ingredientId;

    @ManyToOne
    @JoinColumn(name = "recipe_id")
    @JsonBackReference
    private Recipe recipe;

    @Column(name = "name")
    private String name;

    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "material_id")
    private RawMaterial rawMaterial;
}
