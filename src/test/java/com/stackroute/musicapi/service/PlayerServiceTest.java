package com.stackroute.musicapi.service;

import com.stackroute.musicapi.domain.Player;
import com.stackroute.musicapi.exception.PlayerAlreadyExistException;
import com.stackroute.musicapi.exception.PlayerNotFoundException;
import com.stackroute.musicapi.repository.GameRepository;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.mongodb.repository.support.MongoAnnotationProcessor;

import java.util.ArrayList;
import java.util.List;
import static org.mockito.Mockito.*;

public class UserServiceTest {



    private Player player;

    // Mock class for game repository
    @Mock
    private GameRepository gameRepository;

    // Injected mock class
    @InjectMocks
    private GameServicesImpl gameServices;

    List<Player> playerList = null;



    // Before the test starts

    @Before
    public void setUp(){
        //Initialising the mock object
        MockitoAnnotations.initMocks(this);
        player = new Player();
        player.setPlayerId(2);
        player.setPlayerName("Shubojeet");
        player.setScore(45);
        playerList = new ArrayList<>();
        playerList.add(player);
    }


    @Test
    public void saveUserTestSuccess() throws PlayerAlreadyExistException{


        when(gameRepository.save((Player) ArgumentMatchers.any())).thenReturn(player);
        Player savedPlayer = gameServices.saveUser(player);
        Assert.assertEquals(player,savedPlayer);

        // Here we are verifying that userrepository save method is only called once
        verify(gameRepository,times(1)).save(player);


    }

// if player is not present

    @Test(expected = PlayerAlreadyExistException.class)
    public void saveUserTestFailure() throws PlayerAlreadyExistException{


        when(gameRepository.save((Player) ArgumentMatchers.any())).thenReturn(null);
        Player savedPlayer = gameServices.saveUser(player);
        Assert.assertNotEquals(player,savedPlayer);

        // Here we are verifying that userrepository save method is only called once
        verify(gameRepository,times(1)).save(player);
    }


    // verify the get all user tests

    @Test
    public void getAllUser(){

        gameRepository.save(player);
        //stubbing the mock to return specific data
        when(gameRepository.findAll()).thenReturn(playerList);
        List<Player> listOfTrack = gameServices.getListOfTrack();
        Assert.assertEquals(playerList,listOfTrack);

    }

    @Test
    public void getAllUserFailure(){

        gameRepository.save(player);
        //stubbing the mock to return specific data
        when(gameRepository.findAll()).thenReturn(null);
        List<Player> listOfTrack = gameServices.getListOfTrack();
        Assert.assertNotEquals(playerList,listOfTrack);

    }

    //test for player by name

    @Test(expected = PlayerAlreadyExistException.class)
    public void searchPlayerByname() throws PlayerNotFoundException {

        gameRepository.searchByName("gopal");
        // stubbing the mpcck to return list of matching friends


        when(gameRepository.searchByName("gopal")).thenReturn(playerList);
        List<Player> listOfTrack = gameServices.getPlayerByName("gopal");
        Assert.assertEquals(playerList,listOfTrack);

    }







}
