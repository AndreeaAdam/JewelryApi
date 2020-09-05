package org.example.exception;

public class GemstoneNotFoundException extends JewelreyApiException {
    private static final String MESSAGE = "The gemstone specified is not found";

    public GemstoneNotFoundException(){
        super(MESSAGE);
    }
}
