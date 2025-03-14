package com.rvcode.Application.ManagementApp.exceptionHandller;

public class CustomException extends RuntimeException {
    public CustomException(String message) {
        super(message);
    }
}
