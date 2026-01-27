package com.malob.order_service.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InvalidOrderException.class)
    public ResponseEntity<String> handleInvalidOrder(InvalidOrderException e) {
        return ResponseEntity.badRequest().body(e.getMessage());
    }
}
