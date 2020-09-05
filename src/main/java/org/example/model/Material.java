package org.example.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "PM_MATERIAL_ID_FK"))
    private ProductMaterial productMaterial;
}
