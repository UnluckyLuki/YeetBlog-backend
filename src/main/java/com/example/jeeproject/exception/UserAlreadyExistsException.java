package com.example.jeeproject.exception;

public class UserAlreadyExistsException extends RuntimeException {
    public UserAlreadyExistsException(String name) {
        super("User with name: " + name + " already exists");
    }
}
