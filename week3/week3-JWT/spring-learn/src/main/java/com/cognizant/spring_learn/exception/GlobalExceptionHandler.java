package com.cognizant.springlearn.exception;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Object> handleValidationErrors(
            MethodArgumentNotValidException exception) {

        LOGGER.info("START");

        Map<String, Object> body =
                new LinkedHashMap<>();

        body.put("timestamp", new Date());
        body.put("status", HttpStatus.BAD_REQUEST.value());

        List<String> errors =
                exception
                        .getBindingResult()
                        .getFieldErrors()
                        .stream()
                        .map(error -> error.getDefaultMessage())
                        .toList();

        body.put("errors", errors);

        LOGGER.info("END");

        return new ResponseEntity<>(
                body,
                HttpStatus.BAD_REQUEST
        );
    }
}