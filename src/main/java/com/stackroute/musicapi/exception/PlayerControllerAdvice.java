package com.stackroute.musicapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@ControllerAdvice
public class PlayerControllerAdvice {


    @ExceptionHandler(value = PlayerNotFoundException.class)
    public ResponseEntity<String> PlayerNotFoundException(PlayerNotFoundException e) {
        return new ResponseEntity<>("Player Not Found Exception " + e.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(value = PlayerAlreadyExistException.class)
    public ResponseEntity<String> playerAlreadyExistException(PlayerAlreadyExistException e) {
        return new ResponseEntity<>("Player Already Exists Exception " + e.getMessage(), HttpStatus.CONFLICT);
    }


}
