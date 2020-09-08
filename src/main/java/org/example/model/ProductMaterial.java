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

    @ManyToOne
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "PM_PRODUCT_ID_FK"))
    private Product product;

    @ManyToOne
    @JoinColumn(name = "material_id", foreignKey = @ForeignKey(name = "PM_MATERIAL_ID_FK"))
    private Material material;

}
