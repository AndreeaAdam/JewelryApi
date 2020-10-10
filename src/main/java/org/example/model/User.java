package org.example.model;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String userName;
    private String password;
    private String firstName;
    private String lastName;
    private String telephone;
    private String email;
    private boolean isAdministrator;

    @OneToMany(mappedBy = "user")
    private List<Cart> carts;
}
