package org.example.service;

import org.example.dto.UserDto;
import org.example.exception.UserAccessDeniedException;
import org.example.exception.UserNotFoundException;
import org.example.mapper.UserMapper;
import org.example.model.User;
import org.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private UserMapper mapper;

    public List<UserDto> getAllUsers() {
        List<User> users = userRepository.findAll();
        return users
                .stream()
                .map(user -> mapper.userToDto(user))
                .collect(Collectors.toList());
    }

    public UserDto authenticate(UserDto userDto) throws UserAccessDeniedException {
        User user = userRepository.getUserByUserNameAndPassword(userDto.getUserName(), userDto.getPassword());
        if(userDto.getUserName() == null && userDto.getPassword() == null){
            throw new UserAccessDeniedException();
        }
        return mapper.userToDto(user);
    }

    public UserDto getUserById(Long id) throws UserNotFoundException {
        User user = userRepository.findById(id).orElse(null);
        UserDto userDto;
        if (user != null) {
            userDto = mapper.userToDto(user);
        } else {
            throw new UserNotFoundException();
        }
        return userDto;
    }

    public UserDto saveUser(UserDto userDto) throws UserNotFoundException {
        if (userDto.getId() != null && userDto.getId() > 0
                && !userRepository.existsById(userDto.getId())) {
            throw new UserNotFoundException();
        }
        User user = mapper.userDtoToModel(userDto);
        user = userRepository.save(user);
        return mapper.userToDto(user);
    }

    public UserDto deleteUser(Long id) throws UserNotFoundException {
        UserDto userDto = getUserById(id);
        userRepository.delete(mapper.userDtoToModel(userDto));
        return userDto;
    }
}
