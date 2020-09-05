package org.example.exception;

public class UserNotFoundException extends JewelreyApiException {
    private static final String MESSAGE = "The user specified is not found! ";

    public UserNotFoundException() {
        super(MESSAGE);
    }
}
