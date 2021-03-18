package com.project.cocktailcloud;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
interface GameRepository extends JpaRepository<Game, Long> {

    //Query for /getGame
    @Query
    List<Game> findByMinPlayerLessThanEqualAndMaxPlayerGreaterThanEqualAndGenre1Equals(
            int minPlayer, int maxplayer, String genre1);

    //Query for /getGame
    @Query
    List<Game> findByMinPlayerLessThanEqualAndMaxPlayerGreaterThanEqualAndGenre2Equals(
            int minPlayer, int maxplayer, String genre2);

    //Query for /getGame
    @Query
    List<Game> findByMinPlayerLessThanEqualAndMaxPlayerGreaterThanEqualAndGenre3Equals(
            int minPlayer, int maxplayer, String genre3);

}
