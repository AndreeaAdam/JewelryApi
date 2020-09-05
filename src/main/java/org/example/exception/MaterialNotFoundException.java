package org.example.exception;

public class MaterialNotFoundException extends JewelreyApiException {
    private static final String MESSAGE = "The material specified is not found";

    public MaterialNotFoundException(){
        super(MESSAGE);
    }
}
