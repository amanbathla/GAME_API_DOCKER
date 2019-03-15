package com.stackroute.musicapi.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.stackroute.musicapi.domain.Player;
import com.stackroute.musicapi.exception.PlayerAlreadyExistException;
import com.stackroute.musicapi.repository.GameRepository;
import com.stackroute.musicapi.service.GameService;
import com.stackroute.musicapi.service.GameServicesImpl;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@WebMvcTest
public class PlayerControllerTests {


    private Player player;

    @Mock
    private GameRepository gameRepository;

    @InjectMocks
    private GameController gameController;

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private GameServicesImpl gameServices;

    private List<Player> playerList =null;


   @Before
    public void setUp(){
       MockitoAnnotations.initMocks(this);
       mockMvc = MockMvcBuilders.standaloneSetup(gameController).build();
       player = new Player();
       player.setScore(25);
       player.setPlayerName("Aman");
       player.setPlayerId(1);


   }



    @Test
    public void saveUser() throws Exception {
        when(gameServices.saveUser(any())).thenReturn(player);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/game")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(player)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());


    }
    @Test
    public void saveUserFailure() throws Exception {
        when(gameServices.saveUser(any())).thenThrow(PlayerAlreadyExistException.class);
        mockMvc.perform(MockMvcRequestBuilders.post("/api/v1/game")
                .contentType(MediaType.APPLICATION_JSON).content(asJsonString(player)))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andDo(MockMvcResultHandlers.print());
    }


    private static String asJsonString(final Object obj)
    {
        try{
            return new ObjectMapper().writeValueAsString(obj);

        }catch(Exception e){
            throw new RuntimeException(e);
        }
    }




}
