package org.example.mapper;

import org.example.dto.MaterialDto;
import org.example.model.Material;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface MaterialMapper {
    Material materialDtoToModel(MaterialDto dto);

    MaterialDto materialToDto(Material model);
}
