package com.stackroute.musicapi.configuration;

import com.stackroute.musicapi.domain.Player;
import com.stackroute.musicapi.exception.PlayerAlreadyExistException;
import com.stackroute.musicapi.service.GameService;
import com.stackroute.musicapi.service.GameServiceImpl2;
import com.stackroute.musicapi.service.GameServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class StartUpCommandLineRunner implements CommandLineRunner {



    @Value("${playerName4}")
    String player4;

    @Value("${score4}")
    int score4;

    @Value("${id4}")
    int id4;

    @Value("${playerName5}")
    String player5;

    @Value("${score5}")
    int score5;

    @Value("${id5}")
    int id5;

    @Autowired
   private GameServicesImpl gameServices;

    @Override
    public void run(String... args) throws Exception {

        try {
            gameServices.saveUser(new Player(id4,player4,score4));
            gameServices.saveUser(new Player(id5,player5,score5));
        }
        catch (PlayerAlreadyExistException e) {
            e.printStackTrace();
        }
    }

}
