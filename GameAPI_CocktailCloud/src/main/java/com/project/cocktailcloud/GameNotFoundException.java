package com.project.cocktailcloud;

class GameNotFoundException extends RuntimeException {

    GameNotFoundException(Long id) {
        super("Could not find game " + id);
    }
}
