package com.stackroute.musicapi.exception;

import org.springframework.beans.factory.annotation.Value;

public class PlayerAlreadyExistException extends Exception {


    private String message;

    public PlayerAlreadyExistException(){}

    public PlayerAlreadyExistException(String message){
        super(message);
        this.message = message;

    }

}
