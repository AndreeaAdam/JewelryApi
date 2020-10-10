package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CartDto {
    private Long id;
    private int quantity;
    private int price;
    private boolean isSold;
    private boolean isPayed;

    private Long productId;
    private Long userId;

}
