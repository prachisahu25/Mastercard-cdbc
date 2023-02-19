package com.example.mastercardcdbc.exception;

public class DuplicateException extends RuntimeException {

    public DuplicateException() {
        super();
    }

    public DuplicateException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateException(String message) {
        super(message);
    }

    public DuplicateException(Throwable cause) {
        super(cause);
    }
}
