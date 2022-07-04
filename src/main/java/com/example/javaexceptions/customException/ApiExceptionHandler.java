package com.example.javaexceptions.customException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = ApiRequestException.class)
    public ResponseEntity<Object> handleApiRequestException(ApiRequestException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        
        // 1. Create payload containing exception details
        ApiException apiException = new ApiException(
                e.getMessage(),
//                e,
                badRequest,
                ZonedDateTime.now(ZoneId.of("UTC"))
        );
        
        // 2. Return response entity
        return new ResponseEntity<>(apiException, badRequest); 
    }
}
