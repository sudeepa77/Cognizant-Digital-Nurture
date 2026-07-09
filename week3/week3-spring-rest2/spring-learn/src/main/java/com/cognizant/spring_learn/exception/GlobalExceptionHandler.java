package com.cognizant.springlearn.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(CountryNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleCountryNotFound(
            CountryNotFoundException exception) {

        ErrorResponse errorResponse =
                new ErrorResponse(exception.getMessage());

        return new ResponseEntity<>(
                errorResponse,
                HttpStatus.NOT_FOUND
        );
    }
}