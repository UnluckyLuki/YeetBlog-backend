package com.example.jeeproject.exception;

public class CommentNotFoundException extends RuntimeException{
    public CommentNotFoundException(Long postId) {
        super("Post with id " + postId + " not found");
    }

    public CommentNotFoundException(String title) {
        super("Post not found with title: " + title);
    }
}
