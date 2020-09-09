package org.example.mapper;

import org.example.dto.ProductDto;
import org.example.model.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    @Mappings({
            @Mapping(source = "categoryId", target = "category.id"),
            @Mapping(source = "genderId", target = "gender.id")
    })
    Product productDtoToModel(ProductDto dto);

    @Mappings({
            @Mapping(source = "category.id", target = "categoryId"),
            @Mapping(source = "gender.id", target = "genderId")
    })
    ProductDto productToDto(Product model);
}
