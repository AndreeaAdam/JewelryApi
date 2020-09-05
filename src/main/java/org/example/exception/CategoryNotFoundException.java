package org.example.exception;

public class CategoryNotFoundException extends JewelreyApiException{
    private static final String MESSAGE = "The category specified is not found";

    public CategoryNotFoundException(){
        super(MESSAGE);
    }
}
