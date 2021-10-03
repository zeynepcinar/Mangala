package com.cinar.Mangala.model;

import com.cinar.Mangala.enums.GameStatus;
import lombok.Getter;
import lombok.Setter;
import nonapi.io.github.classgraph.json.Id;

import java.util.UUID;

@Getter
@Setter
public class Game {

    @Id
    private final String gameId;
    private Pit[] board;
    private Player playerNorth;
    private Player playerSouth;
    private Player playerTurn;
    private Player winner;
    private GameStatus status;

    public Game(Board board) {
        this.gameId = UUID.randomUUID().toString();
        this.board = board.getBoard();
        this.playerNorth = board.getPlayerNorth();
        this.playerSouth = board.getPlayerSouth();
        this.playerTurn = this.playerNorth;
        this.winner = null;
        this.status = null;
    }

    public void changePlayerTurn() {
        if (this.playerTurn == playerNorth) {
            this.playerTurn = playerSouth;
        } else
            this.playerTurn = playerNorth;
    }

    public int isPlayerNorthStoneCountOnPits() {
        int stoneCount = 0;
        for (int i = 7; i < 14; i++) {
            stoneCount += this.board[i].getStoneCount();
        }
        return stoneCount;
    }

    public int isPlayerSouthStoneCountOnPits() {
        int stoneCount = 0;
        for (int i = 0; i < 6; i++) {
            stoneCount += this.board[i].getStoneCount();
        }
        return stoneCount;
    }
}
