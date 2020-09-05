package org.example.exception;

public class ProductMaterialNotFoundException extends JewelreyApiException {
    private static final String MESSAGE = "The product material specified is not found!";

    public ProductMaterialNotFoundException() {
        super(MESSAGE);
    }
}
