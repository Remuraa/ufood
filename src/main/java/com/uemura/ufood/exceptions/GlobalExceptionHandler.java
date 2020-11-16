package com.uemura.ufood.exceptions;


import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
class GlobalExceptionHandler {

    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<String> resourceNotFoundException(ValidacaoException e) {

        return ResponseEntity.badRequest().body(e.getMessage());
    }

}