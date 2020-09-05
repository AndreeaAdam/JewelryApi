package org.example.mapper;

import org.example.dto.GenderDto;
import org.example.model.Gender;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GenderMapper {
    Gender genderDtoToModel(GenderDto dto);

    GenderDto genderToDto(Gender model);
}
