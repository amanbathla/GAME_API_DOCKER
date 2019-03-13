package com.stackroute.musicapi.service;

import com.stackroute.musicapi.domain.Player;
import com.stackroute.musicapi.exception.PlayerAlreadyExistException;
import com.stackroute.musicapi.exception.PlayerNotFoundException;

import java.util.List;

public interface GameService {

    public List<Player> getListOfTrack();

    public Player getUserById(int id);

    public List<Player> getPlayerByName(String name) throws PlayerNotFoundException;

    public Player saveUser(Player player) throws PlayerAlreadyExistException;

    public Player deleteUser(int userId);
}
