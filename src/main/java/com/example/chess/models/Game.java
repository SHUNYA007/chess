package com.example.chess.models;

import com.example.chess.utils.GameStatus;
import com.example.chess.utils.Result;

import javax.persistence.*;
import java.sql.Time;
import java.util.List;

@Entity
@Table(name = "GAMES")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long gameId;

    private Integer numberOfMove;

    @ElementCollection
    @CollectionTable(name="moves",joinColumns = @JoinColumn(name = "game_id"),foreignKey = @ForeignKey(name = "game_id_fk"))
    private List<MovePair> moves;

    private Result result;

    private GameStatus gameStatus;

    @ManyToOne
    @JoinColumn(name="black_player_id",nullable = false)
    private Player blackPlayerName;

    @ManyToOne
    @JoinColumn(name="white_player_id",nullable = false)
    private Player whitePlayerName;

    private Time gameTimeControl;

    public Long getGameId() {
        return gameId;
    }

    public void setGameId(Long gameId) {
        this.gameId = gameId;
    }

    public Integer getNumberOfMove() {
        return numberOfMove;
    }

    public void setNumberOfMove(Integer numberOfMove) {
        this.numberOfMove = numberOfMove;
    }

    public List<MovePair> getMoves() {
        return moves;
    }

    public void setMoves(List<MovePair> moves) {
        this.moves = moves;
    }

    public Result getResult() {
        return result;
    }

    public void setResult(Result result) {
        this.result = result;
    }

    public Player getBlackPlayerName() {
        return blackPlayerName;
    }

    public void setBlackPlayerName(Player blackPlayerName) {
        this.blackPlayerName = blackPlayerName;
    }

    public Player getWhitePlayerName() {
        return whitePlayerName;
    }

    public void setWhitePlayerName(Player whitePlayerName) {
        this.whitePlayerName = whitePlayerName;
    }

    public GameStatus getGameStatus() {
        return gameStatus;
    }

    public void setGameStatus(GameStatus gameStatus) {
        this.gameStatus = gameStatus;
    }

    public Time getGameTimeControl() {
        return gameTimeControl;
    }

    public void setGameTimeControl(Time gameTimeControl) {
        this.gameTimeControl = gameTimeControl;
    }
}
