package org.example.mapper;

import org.example.dto.ProductMaterialDto;
import org.example.model.ProductMaterial;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMaterialMapper {
    @Mappings({
            @Mapping(source = "materialId", target = "material.id"),
            @Mapping(source = "productId", target = "product.id")
    })
    ProductMaterial productMaterialDtoToModel(ProductMaterialDto dto);

    @Mappings({
            @Mapping(source = "material.id", target = "materialId"),
            @Mapping(source = "product.id", target = "productId")
    })
    ProductMaterialDto productMaterialToDto(ProductMaterial model);
}
