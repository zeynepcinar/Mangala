package com.cinar.Mangala.service;

import com.cinar.Mangala.enums.GameStatus;
import com.cinar.Mangala.enums.PlayerType;
import com.cinar.Mangala.exception.GameNotFoundException;
import com.cinar.Mangala.model.Board;
import com.cinar.Mangala.model.Game;
import com.cinar.Mangala.model.Player;
import com.cinar.Mangala.repository.GameRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@AllArgsConstructor()
public class GameServiceImpl implements GameService {

    private static final Player PLAYER_NORTH = new Player(PlayerType.PLAYER_NORTH);
    private static final Player PLAYER_SOUTH = new Player(PlayerType.PLAYER_SOUTH);

    private final GameRepository gameRepository;

    private final MangalaRuleApplier ruleApplier;

    public Game startGame() {
        Board board = new Board(PLAYER_SOUTH, PLAYER_NORTH);
        Game game = new Game(board);
        game.setStatus(GameStatus.CREATED);
        return gameRepository.save(game.getGameId(), game);
    }

    @Override
    public Game makeAMove(String gameId, int pitId) {
        Game game = gameRepository.getGame(gameId);
        if (game == null)
            throw new GameNotFoundException("Game with id: " + gameId + " is not found.");
        game.setStatus(GameStatus.ONGOING);
        ruleApplier.applyRules(game, pitId);
        return game;
    }

    public List<Game> getAllGames() {
        return gameRepository.getAllGames();
    }
}
