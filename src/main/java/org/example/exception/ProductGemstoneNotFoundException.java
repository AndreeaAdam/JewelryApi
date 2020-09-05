package org.example.exception;

public class ProductGemstoneNotFoundException extends JewelreyApiException{
    private static final String MESSAGE = "The product gemstone specified is not found";
    public ProductGemstoneNotFoundException(){
        super(MESSAGE);
    }
}
