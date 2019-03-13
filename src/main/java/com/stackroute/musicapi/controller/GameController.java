package com.stackroute.musicapi.controller;


import com.stackroute.musicapi.domain.Player;
import com.stackroute.musicapi.exception.PlayerAlreadyExistException;
import com.stackroute.musicapi.exception.PlayerNotFoundException;
import com.stackroute.musicapi.service.GameServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@CrossOrigin
public class GameController {


    private GameServicesImpl gameServices;

    @Autowired
    public GameController(GameServicesImpl gameServices) {
        this.gameServices = gameServices;
    }

    public GameController() {

    }

    // Get  Request for getting all the user

    @GetMapping("/games")
    public ResponseEntity<List<Player>> getAllUser(){

        List<Player> userList = gameServices.getListOfTrack();
        return new ResponseEntity<List<Player>>(userList, HttpStatus.OK);
    }


    // get by id


//    @GetMapping("/game/{id}")
//    public ResponseEntity<Player> getAllUser(@PathVariable("id") int userId){
//
//        Player player = gameServices.getUserById(userId);
//        return new ResponseEntity<Player>(player,HttpStatus.OK);
//    }

    // Get by name

    @GetMapping("/game/{name}")
    public ResponseEntity<List<Player>> getByName(@PathVariable("name") String playerName) throws PlayerNotFoundException {
        ResponseEntity responseEntity;

            List<Player> player =  gameServices.getPlayerByName(playerName);
            responseEntity =  new ResponseEntity<List<Player>>(player,HttpStatus.OK);
            return responseEntity;

    }


    // Post the request

    @PostMapping("/game")
    public ResponseEntity<Player> savedUser(@RequestBody @Valid Player player){

        ResponseEntity responseEntity;
        try{
            Player savedUser  = gameServices.saveUser(player);
            responseEntity = new ResponseEntity<Player>(savedUser, HttpStatus.OK);
            return responseEntity;
        }
        catch (PlayerAlreadyExistException ex){

            responseEntity =  new ResponseEntity<String>(ex.getMessage(), HttpStatus.CONFLICT);
            return  responseEntity;
        }

    }



    @DeleteMapping("/game/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable("id") int userId){

        Player deleteUser =  gameServices.deleteUser(userId);
        return new ResponseEntity<String>("User Deleted Successfully", HttpStatus.OK);
    }



}
