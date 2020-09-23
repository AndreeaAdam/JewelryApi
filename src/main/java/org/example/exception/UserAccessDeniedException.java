package org.example.exception;

public class UserAccessDeniedException extends JewelreyApiException {
    private static final String MESSAGE = "Access denied!";
    public UserAccessDeniedException(){
        super(MESSAGE);
    }
}
