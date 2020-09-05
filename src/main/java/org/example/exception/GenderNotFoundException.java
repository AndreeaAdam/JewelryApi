package org.example.exception;


public class GenderNotFoundException extends JewelreyApiException{
    private static final String MESSAGE = "The gender specified is not found";

    public GenderNotFoundException(){
        super(MESSAGE);
    }
}
