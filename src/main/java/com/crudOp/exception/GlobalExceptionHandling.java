package com.crudOp.exception;

import com.crudOp.model.response.CustomErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class GlobalExceptionHandling {

    @ExceptionHandler (NoSuchElementException.class)
    public ResponseEntity<CustomErrorResponse> NoSuchElementException(NoSuchElementException exception){
       CustomErrorResponse response = new CustomErrorResponse(HttpStatus.NOT_FOUND.value(),exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(response);
    }
    @ExceptionHandler (IllegalArgumentException.class)
    public ResponseEntity<CustomErrorResponse>IllegalArgumentException(IllegalArgumentException exception){
         CustomErrorResponse response = new CustomErrorResponse(HttpStatus.BAD_REQUEST.value(),exception.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

}
