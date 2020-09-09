package org.example.mapper;

import org.example.dto.GemstoneDto;
import org.example.model.Gemstone;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GemstoneMapper {

    Gemstone gemstoneDtoToModel(GemstoneDto dto);

    GemstoneDto gemstoneToDto(Gemstone model);
}
