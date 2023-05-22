package com.example.chess.services;

import com.example.chess.models.Player;
import com.example.chess.repos.PlayerRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {

    private final PlayerRepo playerRepo;

    public PlayerService(PlayerRepo playerRepo) {
        this.playerRepo = playerRepo;
    }
    public Iterable<Player> getAllPlayers(){
        return playerRepo.findAll();
    }
    public Player createNewPlayer(Player player){
        return playerRepo.save(player);
    }

    public Player getPlayer(String username){
        return playerRepo.getPlayerByUsername(username);
    }

    public void deletePlayer(Long playerId){
        playerRepo.deleteById(playerId);
    }

}
