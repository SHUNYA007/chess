package com.example.chess.repos;

import com.example.chess.models.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepo extends CrudRepository<Player,Long> {

    public Player getPlayerByUsername(String username);

}
