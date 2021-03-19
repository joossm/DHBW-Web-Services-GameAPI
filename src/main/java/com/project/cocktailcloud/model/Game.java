package com.project.cocktailcloud.model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// Database object class
// Lombok annotation
@Data @EqualsAndHashCode @Entity @Getter @Setter @NoArgsConstructor @ToString
public class Game {

    private @Id
    @GeneratedValue
    Long id;
    private String gameName;
    private int minPlayer;
    private int maxPlayer;
    private String genre1;
    private String genre2;
    private String genre3;
    private String ageAdvisory;

    public Game(String gameName, int minPlayer, int maxPlayer,
                String genre1, String genre2, String genre3, String ageAdvisory) {

        this.gameName = gameName;
        this.minPlayer = minPlayer;
        this.maxPlayer = maxPlayer;
        this.genre1 = genre1;
        this.genre2 = genre2;
        this.genre3 = genre3;
        this.ageAdvisory = ageAdvisory;

    }

}
