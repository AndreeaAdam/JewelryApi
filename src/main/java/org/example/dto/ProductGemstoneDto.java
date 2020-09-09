package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductGemstoneDto {
    private Long id;

    private Long gemstoneId;
    private Long productId;

}
