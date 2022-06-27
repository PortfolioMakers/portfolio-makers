package com.example.portfolioserver.global;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public ResponseEntity validationException(MethodArgumentNotValidException exception) {
        List<ErrorInfo> details = new ArrayList<>();
        for(ObjectError error : exception.getBindingResult().getAllErrors()) {
            String fieldName = ((FieldError)error).getField();
            String className = error.getObjectName();
            details.add(new ErrorInfo( className + "." + fieldName, error.getDefaultMessage()));
        }
        ErrorResponse error = new ErrorResponse("Validation Failed", details);
        return new ResponseEntity(error, HttpStatus.BAD_REQUEST);
    }
}
