package org.example.model;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "product_id", foreignKey = @ForeignKey(name = "PRODUCT_CART_ID_FK"))
    private Product product;


    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "USER_CART_ID_FK"))
    private User user;

    private int quantity;
    private int price;
    private boolean isSold;
    private boolean isPayed;
}
