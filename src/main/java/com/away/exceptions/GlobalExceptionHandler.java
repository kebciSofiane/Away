package com.away.exceptions;

import com.away.exceptions.discovery.DiscoveryAlreadyExistsException;
import com.away.exceptions.discovery.DiscoveryNotFoundException;
import com.away.exceptions.item.ItemAlreadyExistsException;
import com.away.exceptions.item.ItemNotFoundException;
import com.away.exceptions.user.UserAlreadyExistsException;
import com.away.exceptions.user.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {



    // User Exception handler
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ApiError> handleUserNotFound(UserNotFoundException ex) {
        ApiError error = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(UserAlreadyExistsException.class)
    public ResponseEntity<ApiError> handleUserAlreadyExists(UserAlreadyExistsException ex) {
        ApiError error = new ApiError(HttpStatus.CONFLICT, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }



    // Item Exception handler

    @ExceptionHandler(ItemNotFoundException.class)
    public ResponseEntity<ApiError> handleUserNotFound(ItemNotFoundException ex) {
        ApiError error = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ItemAlreadyExistsException.class)
    public ResponseEntity<ApiError> handleUserAlreadyExists(ItemAlreadyExistsException ex) {
        ApiError error = new ApiError(HttpStatus.CONFLICT, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }



    // Discovery Exception handler

    @ExceptionHandler(DiscoveryNotFoundException.class)
    public ResponseEntity<ApiError> handleUserNotFound(DiscoveryNotFoundException ex) {
        ApiError error = new ApiError(HttpStatus.NOT_FOUND, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(DiscoveryAlreadyExistsException.class)
    public ResponseEntity<ApiError> handleUserAlreadyExists(DiscoveryAlreadyExistsException ex) {
        ApiError error = new ApiError(HttpStatus.CONFLICT, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }


    // Request validation errors

    @ExceptionHandler(MethodArgumentNotValidException .class)
    public ResponseEntity<ApiError> handleValidationException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();

        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );

        ApiError apiError = new ApiError(
                HttpStatus.BAD_REQUEST.value(),
                "Validation error",
                errors.toString()
        );

        return new ResponseEntity<>(apiError, HttpStatus.BAD_REQUEST);
    }

    //Generic exceptions
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGeneric(Exception ex) {
        ApiError error = new ApiError(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
