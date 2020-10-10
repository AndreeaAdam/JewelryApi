package org.example.service;

import org.example.dto.CartDto;
import org.example.exception.CartNotFoundException;
import org.example.mapper.CartMapper;
import org.example.model.Cart;
import org.example.repository.CartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;
@Component
public class CartService {
    @Autowired
    private CartRepository cartRepository;
    @Autowired
    private CartMapper mapper;

    public List<CartDto> getAllCarts() {
        List<Cart> carts = cartRepository.findAll();
        return carts
                .stream()
                .map(cart -> mapper.cartToDto(cart))
                .collect(Collectors.toList());
    }

    public CartDto getCartById(Long id) throws CartNotFoundException {
        Cart cart = cartRepository.findById(id).orElse(null);
        CartDto result = null;
        if (cart != null) {
            result = mapper.cartToDto(cart);
        } else{
            throw new CartNotFoundException();
        }
        return result;
    }

    public CartDto saveCart(CartDto cartDto) throws CartNotFoundException {
        if (cartDto.getId() != null && cartDto.getId() > 0
                && !cartRepository.existsById(cartDto.getId())) {
            throw new CartNotFoundException();
        }
        Cart cart = mapper.cartDtoToModel(cartDto);
        cart = cartRepository.save(cart);
        return mapper.cartToDto(cart);

    }

    public CartDto deleteCart(Long id) throws CartNotFoundException {
        CartDto cartDto = getCartById(id);
        cartRepository.delete(mapper.cartDtoToModel(cartDto));
        return cartDto;
    }}
