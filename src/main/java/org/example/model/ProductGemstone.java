package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class ProductGemstone {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "gemstone")
    private List<Product> products;

    @OneToMany(mappedBy = "productGemstone")
    private List<Gemstone> gemstones;
}
