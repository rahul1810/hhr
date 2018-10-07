package com.heavenhr.heavenhr.exception;

public class ApplicationNotFoundException extends Exception{
    public ApplicationNotFoundException(String errorMessage) {
        super(errorMessage);
    }
}
