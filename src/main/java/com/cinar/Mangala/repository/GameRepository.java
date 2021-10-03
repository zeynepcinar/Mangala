package com.cinar.Mangala.repository;

import com.cinar.Mangala.exception.GameNotFoundException;
import com.cinar.Mangala.model.Game;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import static java.util.stream.Collectors.toCollection;

@Service
public class GameRepository {

    private static final Map<String, Game> gameMap = new ConcurrentHashMap<>();

    /**
     * This method save the game object with gameId to a Map.
     *
     * @param gameId id of the game
     * @param game   game object to save
     * @return Game object.
     */
    public Game save(String gameId, Game game) {
        gameMap.put(gameId, game);
        return gameMap.get(gameId);
    }

    /**
     * This method will return the game object by id.
     *
     * @param id of the game.
     * @return Game
     */
    public Game getGame(String id) {
        Game game = gameMap.get(id);
        if (game == null) {
            throw new GameNotFoundException("Game with " + id + " is not found");
        }
        return game;
    }

    /**
     * This method will return the all games.
     *
     * @return List of Game
     */
    public List<Game> getAllGames() {
        return gameMap.values().stream().collect(toCollection(ArrayList::new));
    }

}
