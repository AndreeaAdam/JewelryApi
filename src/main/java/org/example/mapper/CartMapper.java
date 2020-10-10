package org.example.mapper;

import org.example.dto.CartDto;
import org.example.model.Cart;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")

public interface CartMapper {
    @Mappings({
            @Mapping(source = "userId", target = "user.id"),
            @Mapping(source = "productId", target = "product.id")
    })
    Cart cartDtoToModel(CartDto dto);

    @Mappings({
            @Mapping(source = "user.id", target = "userId"),
            @Mapping(source = "product.id", target = "productId")
    })
    CartDto cartToDto(Cart model);
}
