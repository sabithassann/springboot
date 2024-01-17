package com.sabit.nexchain.model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "raw_material")
public class RawMaterial {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "material_id")
    private Long materialID;

    @Column(name = "material_name")
    private String materialName;

    @Column(name = "material_type")
    private String materialType;


}
