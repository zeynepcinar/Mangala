package com.cinar.Mangala.service;

import com.cinar.Mangala.model.Game;

import java.util.List;

public interface GameService {

    Game startGame();

    Game makeAMove(String gameId, int pitId);

    List<Game> getAllGames();

}
