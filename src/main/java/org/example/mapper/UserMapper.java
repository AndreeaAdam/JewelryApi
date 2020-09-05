package org.example.mapper;

import org.example.dto.UserDto;
import org.example.model.User;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userDtoToModel(UserDto dto);

    UserDto userToDto(User model);
}
