package com.stackroute.musicapi.service;

import com.stackroute.musicapi.domain.Player;
import com.stackroute.musicapi.exception.PlayerAlreadyExistException;
import com.stackroute.musicapi.exception.PlayerNotFoundException;

import java.util.List;

public class GameServiceImpl2 implements GameService {

    @Override
    public List<Player> getListOfTrack() {
        return null;
    }

    @Override
    public Player getUserById(int id) {
        return null;
    }

    @Override
    public List<Player> getPlayerByName(String name) throws PlayerNotFoundException {
        return null;
    }

    @Override
    public Player saveUser(Player player) throws PlayerAlreadyExistException {
        return null;
    }

    @Override
    public Player deleteUser(int userId) {
        return null;
    }
}
