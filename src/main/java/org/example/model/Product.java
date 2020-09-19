package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", foreignKey = @ForeignKey(name = "CATEGORY_ID_FK"))
    private Category category;

    private String  price;

    @ManyToOne
    @JoinColumn(name = "gender_id", foreignKey = @ForeignKey(name = "GENDER_ID_FK"))
    private Gender gender;

    private String description;
    private String detail;
    private Long quantity;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductGemstone> productGemstones;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductMaterial> productMaterials;
}
