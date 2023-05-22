package com.example.chess.services;

import com.example.chess.models.Game;
import com.example.chess.repos.GameRepo;
import com.example.chess.utils.GameStatus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GameService {

    @Autowired
    GameRepo gameRepo;

    public void createNewGame(Game game){
        game.setGameStatus(GameStatus.STARTED);
        gameRepo.save(game);
    }
}
