package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data

public class Material {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @OneToMany(mappedBy = "material")
    private List<ProductMaterial> productMaterials;

}
