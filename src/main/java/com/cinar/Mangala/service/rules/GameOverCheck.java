package com.cinar.Mangala.service.rules;

import com.cinar.Mangala.enums.GameStatus;
import com.cinar.Mangala.model.Board;
import com.cinar.Mangala.model.Game;

import static com.cinar.Mangala.constants.Constants.PLAYER_NORTH_HOUSE_INDEX;
import static com.cinar.Mangala.constants.Constants.PLAYER_SOUTH_HOUSE_INDEX;

public class GameOverCheck extends MangalaRule {

    public void apply(Game game, int selectedPitId) {
        if (game.isPlayerNorthStoneCountOnPits() == 0 || game.isPlayerSouthStoneCountOnPits() == 0) {

            int totalNorthStoneCount = game.getBoard()[PLAYER_NORTH_HOUSE_INDEX].getStoneCount() + game.isPlayerNorthStoneCountOnPits();
            int totalSouthStoneCount = game.getBoard()[PLAYER_SOUTH_HOUSE_INDEX].getStoneCount() + game.isPlayerSouthStoneCountOnPits();

            game.getBoard()[PLAYER_NORTH_HOUSE_INDEX].setStoneCount(totalNorthStoneCount);
            game.getBoard()[PLAYER_SOUTH_HOUSE_INDEX].setStoneCount(totalSouthStoneCount);

            determineWinner(game);
            resetBoard(game);
            game.setStatus(GameStatus.FINISHED);
        }
    }

    private void resetBoard(final Game game) {
        Board board = new Board(game.getPlayerSouth(), game.getPlayerNorth());
        game.setBoard(board.getBoard());
    }

    private void determineWinner(Game game) {
        if (game.getBoard()[PLAYER_NORTH_HOUSE_INDEX].getStoneCount() > game.getBoard()[PLAYER_SOUTH_HOUSE_INDEX].getStoneCount())
            game.setWinner(game.getPlayerNorth());
        else
            game.setWinner(game.getPlayerSouth());
    }
}
