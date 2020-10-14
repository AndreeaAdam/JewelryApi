package org.example.controller;

import org.example.dto.CartDto;
import org.example.exception.CartNotFoundException;
import org.example.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/api")
public class CartController {
    @Autowired
    private CartService cartService;
    ResponseEntity responseEntity;

    @GetMapping("/carts")
    public  ResponseEntity<List<CartDto>> readCart() {
        return new ResponseEntity<>(cartService.getAllCarts(), HttpStatus.OK);
    }

    @GetMapping("/carts/{id}")
    public ResponseEntity<CartDto> getCartById(@PathVariable Long id) {

        try {
            responseEntity = new ResponseEntity(cartService.getCartById(id), HttpStatus.OK);
        } catch (CartNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PutMapping("/carts")
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<CartDto> editCart(@RequestBody CartDto cartDto) {
        try {
            responseEntity = new ResponseEntity(cartService.saveCart(cartDto), HttpStatus.OK);
        } catch (CartNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }

    @PostMapping("/carts")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<CartDto> addCart(@RequestBody CartDto cartDto) {
        try {
            responseEntity = new ResponseEntity(cartService.saveCart(cartDto), HttpStatus.OK);
        } catch (CartNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.BAD_REQUEST);
        }
        return responseEntity;
    }

    @DeleteMapping("/carts/{id}")
    public ResponseEntity<CartDto> deleteCart(@PathVariable Long id) {
        try {
            responseEntity = new ResponseEntity<>(cartService.deleteCart(id), HttpStatus.OK);
        } catch (CartNotFoundException e) {
            responseEntity = new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return responseEntity;
    }
}
