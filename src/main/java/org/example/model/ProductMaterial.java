package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class ProductMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "material")
    private List<Product> products;

    @OneToMany(mappedBy = "productMaterial")
    private List<Material> materials;

}
