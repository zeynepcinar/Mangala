package com.cinar.Mangala.model;

import lombok.Data;
import lombok.Getter;

import static com.cinar.Mangala.constants.Constants.*;

@Data
@Getter
public class Board {


    private final Pit[] board;
    private Player playerNorth;
    private Player playerSouth;

    public Board(Player southPlayer, Player northPlayer) {
        this.playerNorth = northPlayer;
        this.playerSouth = southPlayer;
        this.board = initializeBoard(southPlayer, northPlayer);
    }

    private Pit[] initializeBoard(Player southPlayer, Player northPlayer) {
        Pit[] board = new Pit[NUM_OF_PITS];
        for (int i = FIRST_PIT_INDEX; i < LAST_PIT_INDEX / 2; i++) {
            Pit pit = new Pit(i, DEFAULT_STONE_NUM_ON_PIT, southPlayer.getId(), false);
            board[i] = pit;
        }
        for (int i = LAST_PIT_INDEX / 2 + 1; i < LAST_PIT_INDEX; i++) {
            Pit pit = new Pit(i, DEFAULT_STONE_NUM_ON_PIT, northPlayer.getId(), false);
            board[i] = pit;
        }
        Pit southHousePit = new Pit(LAST_PIT_INDEX / 2, DEFAULT_STONE_NUM_ON_HOUSE, southPlayer.getId(), true);
        Pit northHousePit = new Pit(LAST_PIT_INDEX, DEFAULT_STONE_NUM_ON_HOUSE, northPlayer.getId(), true);
        board[LAST_PIT_INDEX / 2] = southHousePit;
        board[LAST_PIT_INDEX] = northHousePit;
        return board;
    }
}
