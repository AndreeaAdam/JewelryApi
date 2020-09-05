package org.example.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Gender {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String type;

    @OneToOne(mappedBy = "gender")
    private Product product;

}
