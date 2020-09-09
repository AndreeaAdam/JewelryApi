package org.example.mapper;

import org.example.dto.ProductGemstoneDto;
import org.example.model.ProductGemstone;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductGemstoneMapper {
    @Mappings({
            @Mapping(source = "gemstoneId", target = "gemstone.id"),
            @Mapping(source = "productId", target = "product.id")
    })
    ProductGemstone productGemstoneDtoToModel(ProductGemstoneDto dto);

    @Mappings({
            @Mapping(source = "gemstone.id", target = "gemstoneId"),
            @Mapping(source = "product.id", target = "productId")
    })
    ProductGemstoneDto productGemstoneToDto(ProductGemstone model);
}
