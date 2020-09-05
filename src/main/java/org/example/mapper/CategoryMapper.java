package org.example.mapper;

import org.example.dto.CategoryDto;
import org.example.model.Category;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface CategoryMapper {
    Category categoryDtoToModel(CategoryDto dto);

    CategoryDto categoryToDto(Category model);
}
