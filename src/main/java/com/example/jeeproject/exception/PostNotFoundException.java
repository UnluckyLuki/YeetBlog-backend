package com.example.jeeproject.exception;

public class PostNotFoundException extends RuntimeException{
    public PostNotFoundException(Long postId) {
        super("Post with id " + postId + " not found");
    }

    public PostNotFoundException(String title) {
        super("Post not found with title: " + title);
    }
}
