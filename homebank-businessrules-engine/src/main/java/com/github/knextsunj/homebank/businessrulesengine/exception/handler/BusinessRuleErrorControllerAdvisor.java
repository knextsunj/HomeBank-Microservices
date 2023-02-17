package com.github.knextsunj.homebank.businessrulesengine.exception.handler;

import com.github.knextsunj.homebank.businessrulesengine.exception.DataNotFoundException;
import com.github.knextsunj.homebank.businessrulesengine.exception.RequiredInputDataMissingException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

public class BusinessRuleErrorControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(RequiredInputDataMissingException.class)
    public ResponseEntity<Object> handleBusinessRuleException(RequiredInputDataMissingException businessRuleException, WebRequest webRequest) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", businessRuleException.getMessage());
        return new ResponseEntity<>(body, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DataNotFoundException.class)
    public ResponseEntity<Object> handleBusinessRuleException(DataNotFoundException businessRuleException, WebRequest webRequest) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("timestamp", LocalDateTime.now());
        body.put("message", businessRuleException.getMessage());
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
