package com.auto.auto.exception;

import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(ExceptionAuto.class)
    public ResponseEntity<String> manejarException(ExceptionAuto exception){
        return new ResponseEntity<>(exception.getMessage(),HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> manejarExcepcionGeneral(Exception exception){
        return new ResponseEntity<>("Ocurrio un error inesperado, xd? => "+exception.getMessage(),HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
