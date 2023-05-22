package com.example.chess.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "PLAYERS")
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long playerId;
    @Column(unique = true)
    private String username;
    private String name;

    private Integer rating;

    @OneToMany(mappedBy = "blackPlayerName", targetEntity = Game.class,fetch = FetchType.EAGER)
    private Set<Game> gamesAsBlack;

    @OneToMany(mappedBy = "whitePlayerName", targetEntity = Game.class,fetch = FetchType.EAGER)
    private Set<Game> gamesAsWhite;

    public Long getPlayerId() {
        return playerId;
    }

    public void setPlayerId(Long playerId) {
        this.playerId = playerId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Game> getGamesAsBlack() {
        return gamesAsBlack;
    }

    public void setGamesAsBlack(Set<Game> gamesAsBlack) {
        this.gamesAsBlack = gamesAsBlack;
    }

    public Set<Game> getGamesAsWhite() {
        return gamesAsWhite;
    }

    public void setGamesAsWhite(Set<Game> gamesAsWhite) {
        this.gamesAsWhite = gamesAsWhite;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
