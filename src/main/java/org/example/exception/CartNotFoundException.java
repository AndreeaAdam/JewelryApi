package org.example.exception;

public class CartNotFoundException extends JewelreyApiException{
    private static final String MESSAGE = "Cart not found!";
    public CartNotFoundException(){
        super(MESSAGE);
    }
}
