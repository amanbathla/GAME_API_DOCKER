package com.stackroute.musicapi.exception;

import org.springframework.hateoas.VndErrors;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@ControllerAdvice
public class PlayerControllerAdvice {

    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<String> exceptionhandler(Exception e)
    {
        return new ResponseEntity<>("erorr exception Occured Global " +e.getMessage(), HttpStatus.CONFLICT);
    }
}
