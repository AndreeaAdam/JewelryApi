package org.example.controller;

import org.example.dto.UserDto;
import org.example.exception.UserNotFoundException;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;
    ResponseEntity responseEntity;

    @GetMapping("/users")
    public List<UserDto> readUsers() {
        List<UserDto> userDtos = userService.getAllUsers();
        return userDtos;
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        try {
            responseEntity = new ResponseEntity(userService.getUserById(id), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PutMapping("/users/authenticate")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDto> authenticate(@RequestBody UserDto userDto) {
//        try {
            responseEntity = new ResponseEntity(userService.authenticate(userDto), HttpStatus.OK);
//        } catch (UserNotFoundException e) {
//            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
//        }
        return responseEntity;
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDto> addUser(@RequestBody UserDto userDto) {
        try {
            responseEntity = new ResponseEntity(userService.saveUser(userDto), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @PutMapping("/users")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDto> editUser(@RequestBody UserDto userDto) {
        try {
            responseEntity = new ResponseEntity(userService.saveUser(userDto), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<UserDto> deleteUser(@PathVariable Long id) {
        try {
            responseEntity = new ResponseEntity(userService.deleteUser(id), HttpStatus.OK);
        } catch (UserNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

}
