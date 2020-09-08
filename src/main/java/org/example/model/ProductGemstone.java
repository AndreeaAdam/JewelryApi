package org.example.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ProductGemstone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "PG_PRODUCT_ID_FK"))
    private Product product;
    @ManyToOne
    @JoinColumn(name = "gemstone_id", foreignKey = @ForeignKey(name = "PG_GEMSTONE_ID_FK"))
    private Gemstone gemstone;


}
