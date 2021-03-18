package com.project.cocktailcloud;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorMvcAutoConfiguration;
import org.springframework.hateoas.CollectionModel;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@EnableAutoConfiguration(exclude = {ErrorMvcAutoConfiguration.class})
//RestController of the web-service
@RestController
class GameController {

    //connection to gameRepository
    final
    GameRepository gameRepository;

    public GameController(GameRepository gameRepository) {
        this.gameRepository = gameRepository;
    }

    // GET Method to get all Games
    @GetMapping("/game")
    CollectionModel<EntityModel<Game>> all() {

        List<EntityModel<Game>> games = gameRepository.findAll().stream()
                .map(game -> EntityModel.of(game,
                        linkTo(methodOn(GameController.class).one(game.getId())).withSelfRel(),
                        linkTo(methodOn(GameController.class).all()).withRel("games")))
                .collect(Collectors.toList());

        return CollectionModel.of(games, linkTo(methodOn(GameController.class).all()).withSelfRel());
    }

    // POST Method to add one game
    @PostMapping("/game")
    Game newGame(@RequestBody Game newGame) {
        return gameRepository.save(newGame);
    }

    // GET Method to get a game by ID
    @GetMapping("/game/{id}")
    EntityModel<Game> one(@PathVariable Long id) {

        Game game = gameRepository.findById(id)
                .orElseThrow(() -> new GameNotFoundException(id));

        return EntityModel.of(game,
                linkTo(methodOn(GameController.class).one(id)).withSelfRel(),
                linkTo(methodOn(GameController.class).all()).withRel("cocktails"));
    }

    //PUT Method to update/replace a game
    @PutMapping("/game/{id}")
    Game replaceGame(@RequestBody Game newGame, @PathVariable Long id) {

        return gameRepository.findById(id)
                .map(game -> {
                    game.setGameName(newGame.getGameName());
                    return gameRepository.save(game);
                })
                .orElseGet(() -> {
                    newGame.setId(id);
                    return gameRepository.save(newGame);
                });
    }

    //DELETE Method to delete a game by ID
    @DeleteMapping("/game/{id}")
    void deleteGame(@PathVariable Long id) {
        gameRepository.deleteById(id);
    }

    //GET Method to find games by amount of players and specific gernes
    @CrossOrigin
    @GetMapping("/game/getGame")
    public ResponseEntity<List<Game>> getGames(@RequestParam() int player, String genre1, String genre2, String genre3) {
        try {
            List<Game> games = new ArrayList<>();
            games.addAll(gameRepository.findByMinPlayerLessThanEqualAndMaxPlayerGreaterThanEqualAndGenre1Equals(player, player, genre1));
            games.addAll(gameRepository.findByMinPlayerLessThanEqualAndMaxPlayerGreaterThanEqualAndGenre1Equals(player, player, genre2));
            games.addAll(gameRepository.findByMinPlayerLessThanEqualAndMaxPlayerGreaterThanEqualAndGenre1Equals(player, player, genre3));
            games.addAll(gameRepository.findByMinPlayerLessThanEqualAndMaxPlayerGreaterThanEqualAndGenre2Equals(player, player, genre1));
            games.addAll(gameRepository.findByMinPlayerLessThanEqualAndMaxPlayerGreaterThanEqualAndGenre2Equals(player, player, genre2));
            games.addAll(gameRepository.findByMinPlayerLessThanEqualAndMaxPlayerGreaterThanEqualAndGenre2Equals(player, player, genre3));
            games.addAll(gameRepository.findByMinPlayerLessThanEqualAndMaxPlayerGreaterThanEqualAndGenre3Equals(player, player, genre1));
            games.addAll(gameRepository.findByMinPlayerLessThanEqualAndMaxPlayerGreaterThanEqualAndGenre3Equals(player, player, genre2));
            games.addAll(gameRepository.findByMinPlayerLessThanEqualAndMaxPlayerGreaterThanEqualAndGenre3Equals(player, player, genre3));

            //Search for Duplicates
            Set<Game> set = new HashSet<>(games);
            games.clear();
            games.addAll(set);

            //Event Handling
            if (games.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }

            return new ResponseEntity<>(games, HttpStatus.OK);

        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}

