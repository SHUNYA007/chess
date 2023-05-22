package com.example.chess.utils;

public enum Result {

    WHITE_WON(0),
    BLACK_WON(1),
    WHITE_LOST(2),
    BLACK_LOST(3),
    STALEMATE(4);
    private final Integer value;
    Result(Integer value){
        this.value = value;
    }
}
