package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;

    @OneToMany(mappedBy = "gender")
    private List<Product> products;
}
