package com.example.chess.models;

import javax.persistence.Embeddable;


@Embeddable
public class MovePair {

    private Long moveId;

    private String whiteMove;
    private String blackMove;

    MovePair(String whiteMove,String blackMove){
        this.blackMove = blackMove;
        this.whiteMove = whiteMove;
    }

    public String getWhiteMove() {
        return whiteMove;
    }

    public void setWhiteMove(String whiteMove) {
        this.whiteMove = whiteMove;
    }

    public String getBlackMove() {
        return blackMove;
    }

    public void setBlackMove(String blackMove) {
        this.blackMove = blackMove;
    }
    public Long getMoveId() {
        return moveId;
    }

    public void setMoveId(Long moveId) {
        this.moveId = moveId;
    }


}
