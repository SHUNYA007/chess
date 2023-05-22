package com.example.chess.repos;

import com.example.chess.models.Game;
import org.springframework.data.repository.CrudRepository;

public interface GameRepo extends CrudRepository<Game,Long> {
}
