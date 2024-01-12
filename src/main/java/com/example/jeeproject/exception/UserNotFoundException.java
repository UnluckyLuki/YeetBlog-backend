package com.example.jeeproject.exception;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(Long userId) {
        super("User with id " + userId + " not found");
    }

    public UserNotFoundException(String name) {
        super("User not found with name: " + name);
    }
}
