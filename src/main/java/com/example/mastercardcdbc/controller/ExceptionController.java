package com.example.mastercardcdbc.controller;

import com.example.mastercardcdbc.exception.DuplicateException;
import com.example.mastercardcdbc.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionController  extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ ResourceNotFoundException.class , DuplicateException.class})
    public ResponseEntity<Object> handleResourceNotFoundException(
            Exception ex) {
        return new ResponseEntity<>(
                ex.getMessage(),  HttpStatus.NOT_FOUND);
    }

   @ExceptionHandler({ Exception.class })
    public ResponseEntity<Object> handleFoundException(
            Exception ex) {
        return new ResponseEntity<>(
                ex.getMessage(),  HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
