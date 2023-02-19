package com.example.mastercardcdbc.controller;

import com.example.mastercardcdbc.exception.DuplicateException;
import com.example.mastercardcdbc.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(
            Exception ex) {
        return new ResponseEntity<>(
                ex.getMessage(), HttpStatus.NOT_FOUND);
    }


    @ExceptionHandler({Exception.class, DuplicateException.class})
    public ResponseEntity<Object> handleFoundException(
            Exception ex) {
        return new ResponseEntity<>(
                ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler
            (MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return new ResponseEntity<>(
                errors, HttpStatus.BAD_REQUEST);
    }
}
