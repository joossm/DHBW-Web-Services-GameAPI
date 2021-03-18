package com.project.cocktailcloud;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
class LoadDatabase {

    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(GameRepository repository) {

        return args -> {
            //Creating the Database's entrys
            repository.save(new Game("UNO", 2, 10, "Family", "Party", "Card Game", "6"));
            repository.save(new Game("Monopoly", 2, 8, "Family", "Party", "Board Game", "8"));
            repository.save(new Game("Cluedo", 2, 6, "Family", "Party", "Board Game", "8"));
            repository.save(new Game("Chess", 2, 2, "Family", "Party", "Board Game", "12"));
            repository.save(new Game("Scrabble", 2, 4, "Family", "Party", "Board Game", "0"));
            repository.save(new Game("Risk", 2, 6, "Family", "Party", "Board Game", "10"));
            repository.save(new Game("Settlers of Catan", 3, 4, "Family", "Party", "Board Game", "6"));
            repository.save(new Game("Carcassonne", 2, 5, "Family", "Party", "Board Game", "6"));
            repository.save(new Game("Connect Four", 2, 2, "Family", "Party", "Board Game", "6"));
            repository.save(new Game("The Game of Life", 2, 4, "Family", "Party", "Board Game", "8"));
            repository.save(new Game("Skip-Bo", 2, 2, "Family", "Party", "Card Game", "0"));
            repository.save(new Game("Skat", 3, 3, "Family", "Party", "Card Game", "12"));
            repository.save(new Game("Scrawl", 6, 8, "Party", "Adult", "Drawing", "17"));
            repository.save(new Game("Magic Maze", 1, 8, "Cooperation", "Communication", "Board Game", "8"));
            repository.save(new Game("Legends of Andor", 2, 4, "Cooperation", "Strategy", "Board Game", "10"));
            repository.save(new Game("Gloomhaven", 1, 4, "Cooperation", "Strategy", "Board Game", "14"));
            repository.save(new Game("Phase 10", 2, 6, "Family", "Strategy", "Card Game", "10"));
            repository.save(new Game("Pandemic", 2, 4, "Cooperation", "Worker Placement", "Board Game", "12"));
            repository.save(new Game("Azul", 2, 4, "Builder", "Strategy", "Board Game", "8"));
            repository.save(new Game("Codenames", 2, 8, "Communication", "Party", "Deduction", "10"));
            repository.save(new Game("Concept", 4, 16, "Party", "Deduction", "Board Game", "10"));
            repository.save(new Game("Marco Polo", 2, 4, "Worker Placement", "Strategy", "Board Game", "12"));
            repository.save(new Game("Take 6!", 2, 10, "Strategy", "Family", "Card Game", "8"));
            repository.save(new Game("Mice & Mystics", 1, 4, "Party", "Cooperation", "Board Game", "7"));
            repository.save(new Game("Mysterium", 2, 7, "Party", "Deduction", "Board Game", "10"));
            repository.save(new Game("Halli Galli", 2, 6, "Party", "Family", "Reaction", "6"));
            repository.save(new Game("Secret Hitler", 5, 10, "Party", "Drinking", "Card Game", "14"));
            repository.save(new Game("Beer Pong", 2, 6, "Party", "Drinking", "Skill Game", "18"));
            repository.save(new Game("Never have I ever", 2, 10, "Party", "Drinking", "Socialise", "18"));
            repository.save(new Game("Bus Driving Game", 2, 10, "Party", "Drinking", "Socialise", "18"));

            log.info("Preloading the database successful");

        };
    }
}
