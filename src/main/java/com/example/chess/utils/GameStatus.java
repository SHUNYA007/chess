package com.example.chess.utils;

public enum GameStatus {
    STARTED(0),
    PAUSED(1),
    FINISHED(2);

    private final Integer value;
    GameStatus(Integer value){
        this.value = value;
    }
}
