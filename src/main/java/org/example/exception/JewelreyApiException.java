package org.example.exception;

public class JewelreyApiException extends Exception{
    private static final String MESSAGE = "Generic jewelry api not found";

    public JewelreyApiException(){
        super(MESSAGE);
    }
    public JewelreyApiException(String message){
        super(message);
    }
}
