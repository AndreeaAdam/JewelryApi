package org.example.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Gemstone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "PG_GEMSTONE_ID_FK"))
    private ProductGemstone productGemstone;
}