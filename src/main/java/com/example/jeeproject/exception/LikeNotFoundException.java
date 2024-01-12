package com.example.jeeproject.exception;

public class LikeNotFoundException extends RuntimeException{
    public LikeNotFoundException(long userId,long postId) {
        super("Like not found by userId: " + userId + " postId: " + postId);
    }

    }
