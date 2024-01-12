package com.example.jeeproject.exception;

public class PostByAuthorNotFoundException extends RuntimeException {
    public PostByAuthorNotFoundException(String author) {
        super("Author: " + author + " don't have any posts");
    }

}
