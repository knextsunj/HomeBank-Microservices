package com.github.knextsunj.homebank.cardtypemaster.exception;

public class ValidationServiceInvocationException extends RuntimeException {

    public ValidationServiceInvocationException(String message, Throwable throwable) {
        super(message, throwable);
    }

    public ValidationServiceInvocationException(String message) {
        this(message, null);
    }
}
