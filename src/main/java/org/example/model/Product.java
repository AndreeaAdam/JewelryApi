package org.example.model;

import lombok.Data;

import javax.persistence.*;

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

    private double price;

    @OneToOne(mappedBy ="product")
    private Gender gender;

    @ManyToOne
    @JoinColumn(name = "gemstone_id", foreignKey = @ForeignKey(name = "PG_PRODUCT_ID_FK"))
    private Gemstone gemstone;

    @ManyToOne
    @JoinColumn(name = "material_id", foreignKey = @ForeignKey(name = "PM_PRODUCT_ID_FK"))
    private Material material;

    private String description;
    private String detail;
    private Long quantity;

}
