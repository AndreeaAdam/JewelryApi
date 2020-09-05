package org.example.mapper;

import org.example.dto.ProductGemstoneDto;
import org.example.model.ProductGemstone;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductGemstoneMapper {
    ProductGemstone productGemstoneDtoToModel(ProductGemstoneDto dto);

    ProductGemstoneDto productGemstoneToDto(ProductGemstone model);
}
