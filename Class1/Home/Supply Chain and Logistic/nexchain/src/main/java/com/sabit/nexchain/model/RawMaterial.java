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

    public Long getMaterialID() {
        return materialID;
    }

    // Setter method for 'materialID' if necessary
    public void setMaterialID(Long materialID) {
        this.materialID = materialID;
    }

    // Getter method for 'materialName'
    public String getMaterialName() {
        return materialName;
    }

    // Setter method for 'materialName' if necessary
    public void setMaterialName(String materialName) {
        this.materialName = materialName;
    }

    // Getter method for 'materialType'
    public String getMaterialType() {
        return materialType;
    }

    // Setter method for 'materialType' if necessary
    public void setMaterialType(String materialType) {
        this.materialType = materialType;
    }

}
