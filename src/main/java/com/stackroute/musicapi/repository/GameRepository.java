package com.stackroute.musicapi.repository;

import com.stackroute.musicapi.domain.Player;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GameRepository extends CrudRepository<Player,Integer> {


    // if we are using native query

//    @Query(value = "SELECT * FROM Player p where p.playerNamee = ?0",
//            nativeQuery=true
//    )
    // if we are using JPQL query
    @Query("select p from Player p where p.playerName = ?1")
    List<Player> searchByName(String name);

}
