package com.example.jeeproject.controllers;

import com.example.jeeproject.exception.OldPasswordInvalidException;
import com.example.jeeproject.exception.PostNotFoundException;
import com.example.jeeproject.exception.UserAlreadyExistsException;
import com.example.jeeproject.exception.UserNotFoundException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException exception, WebRequest request){
        Map<String, Object> nameToMessage = new HashMap<>();
        nameToMessage.put("message: ", exception.getMessage());
        return new ResponseEntity<>(nameToMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(PostNotFoundException.class)
    public ResponseEntity<?> handlePostNotFoundException(PostNotFoundException exception, WebRequest request){
        Map<String, Object> nameToMessage = new HashMap<>();
        nameToMessage.put("message: ", exception.getMessage());
        return new ResponseEntity<>(nameToMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<?> handleUserAlreadyExistsException(UserAlreadyExistsException exception, WebRequest request){
        Map<String, Object> nameToMessage = new HashMap<>();
        nameToMessage.put("message: ", exception.getMessage());
        return new ResponseEntity<>(nameToMessage, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(OldPasswordInvalidException.class)
    public ResponseEntity<?> handleOldPasswordInvalidException(OldPasswordInvalidException exception, WebRequest request){
        Map<String, Object> nameToMessage = new HashMap<>();
        nameToMessage.put("message: ", exception.getMessage());
        return new ResponseEntity<>(nameToMessage, HttpStatus.BAD_REQUEST);
    }
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult()
                .getFieldErrors()
                .forEach(error -> {
                    if (errors.containsKey(error.getField())) {
                        errors.put(error.getField(), String.format("%s, %s", errors.get(error.getField())));
                    } else {
                        errors.put(error.getField(), error.getDefaultMessage());
                    }
                });

        Map<String, Object> nameToMessage = new HashMap<>();
        nameToMessage.put("timestamp", new Date());
        nameToMessage.put("errors", errors);

        return new ResponseEntity<>(nameToMessage, HttpStatus.BAD_REQUEST);
    }
}
