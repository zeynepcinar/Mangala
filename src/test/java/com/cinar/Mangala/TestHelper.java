package com.cinar.Mangala;

import com.cinar.Mangala.enums.PlayerType;
import com.cinar.Mangala.model.Board;
import com.cinar.Mangala.model.Game;
import com.cinar.Mangala.model.Pit;
import com.cinar.Mangala.model.Player;

import java.util.ArrayList;
import java.util.List;

public class TestHelper {

    public static Game createGame() {
        return new Game(createBoard());
    }

    public static Board createBoard() {
        return new Board(new Player(PlayerType.PLAYER_SOUTH), new Player(PlayerType.PLAYER_NORTH));
    }

    public static List<Game> createMultipleGames() {
        Game firstGame = createGame();
        Game secondGame = createGame();
        List<Game> allGames = new ArrayList<>();
        allGames.add(firstGame);
        allGames.add(secondGame);
        return allGames;
    }

    public static Game createRandomGameOnLastRound() {
        Game game = createGame();
        Pit[] board = game.getBoard();
        for (int i = 0; i < 6; i++) {
            board[i].setStoneCount(0);
        }
        return game;
    }

}