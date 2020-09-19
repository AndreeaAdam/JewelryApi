package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long id;
    private String name;
    private Double price;
    private String description;
    private String detail;
    private Long quantity;

    private Long categoryId;
    private Long genderId;
}
