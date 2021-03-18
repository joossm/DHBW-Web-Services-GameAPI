package com.project.cocktailcloud;

public class GameNoContentException extends RuntimeException {

    GameNoContentException() {
        super("Could not find games with that amount of players or genres");
    }
}
