package com.github.knextsunj.homebank.colorcardmaster.exception.handler;

import com.github.knextsunj.homebank.colorcardmaster.exception.ValidationFailureException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@ControllerAdvice
public class BusinessRuleErrorControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ValidationFailureException.class)
    public ResponseEntity<Object> handleBusinessRuleException(ValidationFailureException exception, WebRequest webRequest) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", exception.getMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
