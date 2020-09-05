package org.example.mapper;

import org.example.dto.ProductMaterialDto;
import org.example.model.ProductMaterial;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMaterialMapper {
    ProductMaterial productMaterialDtoToModel(ProductMaterialDto dto);

    ProductMaterialDto productMaterialToDto(ProductMaterial model);
}
