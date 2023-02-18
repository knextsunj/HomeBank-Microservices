package com.github.knextsunj.homebank.cardtypemaster.exception;

public class ValidationFailureException extends RuntimeException {

    public ValidationFailureException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ValidationFailureException(String message) {
        this(message, null);
    }
}
