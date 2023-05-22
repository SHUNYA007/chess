package com.example.chess.controller;

import com.example.chess.models.Game;
import com.example.chess.services.GameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({"/game"})
public class GameController {

    @Autowired
    GameService gameService;


    @RequestMapping(value = "/createNew", method = RequestMethod.POST)
    public ResponseEntity<String> createNewGame (@RequestBody Game game){
        try{
            gameService.createNewGame(game);
            return new ResponseEntity<>("new Game created",HttpStatus.OK);
        }
        catch(Exception e){
            return new ResponseEntity<>("Can't create new game", HttpStatus.OK);
        }
    }
}
