package com.example.chess.controller;

import com.example.chess.models.Player;
import com.example.chess.services.PlayerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping({"/players"})
public class playerController {
    @Autowired
    PlayerService playerService;
    @RequestMapping(value = "/savePlayer", method = RequestMethod.POST)
    public ResponseEntity<String> savePlayer(@RequestBody Player player) throws JsonProcessingException {

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        try {
            Player savedPlayer = playerService.createNewPlayer(player);
            return new ResponseEntity<String>(ow.writeValueAsString(savedPlayer), HttpStatus.OK);
        }
        catch (DataIntegrityViolationException e){

            return new ResponseEntity<String>("Username Exists", HttpStatus.OK);
        }

    }
    @RequestMapping(value = "/getPlayer", method = RequestMethod.GET)
    public ResponseEntity<String> getPlayerByUsername(@RequestParam(name = "username") String  username) throws JsonProcessingException {

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        Player player = playerService.getPlayer(username);
        if(player != null)
            return new ResponseEntity<String>(ow.writeValueAsString(player), HttpStatus.OK);
        return new ResponseEntity<String>("Player not found",HttpStatus.NOT_FOUND);

    }
    @RequestMapping(value = "/getAllPlayers", method = RequestMethod.GET)
    public ResponseEntity<String> getAllPlayers() throws JsonProcessingException {

        ObjectWriter ow = new ObjectMapper().writer().withDefaultPrettyPrinter();

        Iterable<Player> players = playerService.getAllPlayers();
        return new ResponseEntity<String>(ow.writeValueAsString(players), HttpStatus.OK);
    }

    @RequestMapping(value = "/deletePlayer", method = RequestMethod.DELETE)
    public ResponseEntity<String> deletePlayer(@RequestParam(name = "playerId") Long playerId) throws JsonProcessingException{
        try {
            playerService.deletePlayer(playerId);
            return new ResponseEntity<String>("Player Deleted",HttpStatus.NOT_FOUND);

        }
        catch (Exception e){
            return new ResponseEntity<String>("Player not found",HttpStatus.NOT_FOUND);

        }
    }

}
