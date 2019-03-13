package com.stackroute.musicapi.configuration;

import com.stackroute.musicapi.domain.Player;
import com.stackroute.musicapi.exception.PlayerAlreadyExistException;
import com.stackroute.musicapi.service.GameServicesImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:application.properties")
public class StartUpApplicationListner implements ApplicationListener<ContextRefreshedEvent> {


    @Autowired
    Environment env;

    @Value("${score1}")
    int score1;

    @Value("${id1}")
    int id1;


    @Value("${score2}")
    int score2;


    @Value("${id2}")
    int id2;


    @Value("${score3}")
    int score3;


    @Value("${id3}")
    int id3;

    @Autowired
    private GameServicesImpl gameServices;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {

//
//            gameServices.saveUser(new Player(id1,env.getProperty("playerName1"),score1));
//            gameServices.saveUser(new Player(id2,env.getProperty("playerName2"),score2));
//            gameServices.saveUser(new Player(id3,env.getProperty("playerName3"),score3));


    }
}
