package com.stackroute.musicapi.repository;

import com.stackroute.musicapi.domain.Player;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends MongoRepository<Player, Integer> {

    @Query("{ 'playerName' : ?0 }")
    List<Player> searchByName(String name);

}
