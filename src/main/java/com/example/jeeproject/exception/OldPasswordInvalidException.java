package com.example.jeeproject.exception;

public class OldPasswordInvalidException extends RuntimeException{
    public OldPasswordInvalidException() {super("Old password provided is invalid");}
}
