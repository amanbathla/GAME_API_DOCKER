package com.stackroute.musicapi.service;


import com.stackroute.musicapi.domain.Player;
import com.stackroute.musicapi.exception.PlayerAlreadyExistException;
import com.stackroute.musicapi.exception.PlayerNotFoundException;
import com.stackroute.musicapi.repository.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GameServicesImpl implements GameService {

    private GameRepository gameRepository;

    //Constructor

    @Autowired
    public void setUserRepository(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public GameServicesImpl(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    public GameServicesImpl() {

    }


    //  Get the List of user

    public List<Player> getListOfTrack() {

        List<Player> playerList = (List<Player>) gameRepository.findAll();
        return playerList;

    }

    // Get player  by name

    public List<Player> getPlayerByName(String name) throws PlayerNotFoundException {

        List<Player> playerList = gameRepository.searchByName(name);
        if (playerList.isEmpty()) {
            throw new PlayerNotFoundException("Player not Found");
        } else {
            return playerList;
        }
    }


    // Get user by id

    public Player getUserById(int id) {

        Optional<Player> getUserById = gameRepository.findById(id);
        if (getUserById != null) {
            return getUserById.get();
        } else {
            return null;
        }
    }

    // Saved User to the database

    public Player saveUser(Player player) throws PlayerAlreadyExistException {

        if (gameRepository.existsById(player.getPlayerId())) {
            throw new PlayerAlreadyExistException("User already Exist");
        }

        Player savePlayer = gameRepository.save(player);

        if (savePlayer == null) {
            throw new PlayerAlreadyExistException("User Already Exists");
        }
        return savePlayer;
    }


    public Player updateUser(Player user, int userId) {

        Boolean isUserWithIDExists = gameRepository.existsById(userId);

        if (isUserWithIDExists) {
            Player updateUser = (Player) gameRepository.findById(userId).get();
            updateUser.setPlayerName(user.getPlayerName());
            updateUser.setScore(user.getScore());
            return gameRepository.save(updateUser);
        } else {
            return null;
        }

    }


    // Update user info

    public Player deleteUser(int userId) {
        Player deletedUser = (Player) gameRepository.findById(userId).get();
        gameRepository.deleteById(userId);
        return deletedUser;
    }


}
