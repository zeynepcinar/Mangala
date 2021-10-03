package com.cinar.Mangala.service.rules;

import com.cinar.Mangala.enums.PlayerType;
import com.cinar.Mangala.model.Game;
import com.cinar.Mangala.model.Pit;
import com.cinar.Mangala.model.Player;
import lombok.extern.slf4j.Slf4j;

import static com.cinar.Mangala.constants.Constants.PLAYER_NORTH_HOUSE_INDEX;
import static com.cinar.Mangala.constants.Constants.PLAYER_SOUTH_HOUSE_INDEX;

@Slf4j
public class SowTheStonesRule extends MangalaRule {

    @Override
    public void apply(Game game, int selectedPitId) {
        log.debug("Sowing to stones on the right direction", selectedPitId);
        Pit[] pits = game.getBoard();
        Player currentPlayer = game.getPlayerTurn();
        int stonesInTheHand = game.getBoard()[selectedPitId].getStoneCount();
        pits[selectedPitId].setStoneCount(0);
        int currentIndex = selectedPitId + 1;
        while (stonesInTheHand > 0) {
            if (currentIndex == pits.length)
                currentIndex = currentIndex - pits.length;
            Pit currentPit = pits[currentIndex];
            if (isYourOpponentsHouse(currentPit, currentPlayer))
                currentPit = pits[currentIndex++];
            currentPit.setStoneCount(currentPit.getStoneCount() + 1);
            currentIndex++;
            stonesInTheHand--;
        }
        int lastIndex = currentIndex - 1;
        Pit lastStonePit = pits[lastIndex];
        if (isLastStoneLandYourEmptyPit(lastStonePit, currentPlayer)) {
            int ownHouseIndex = currentPlayer.getPlayerType() == PlayerType.PLAYER_NORTH ? PLAYER_NORTH_HOUSE_INDEX : PLAYER_SOUTH_HOUSE_INDEX;
            captureOpponentsStonesAndPutOwnHouse(ownHouseIndex, lastIndex, pits);
        }
        decideToWhoIsTurn(lastStonePit, game);

        this.next.apply(game, selectedPitId);
    }

    private void captureOpponentsStonesAndPutOwnHouse(int ownHouseIndex, int lastIndex, Pit[] pits) {
        int opponentStones = pits[12 - lastIndex].getStoneCount();
        int allCapturedStones = opponentStones + pits[lastIndex].getStoneCount();
        pits[12 - lastIndex].setStoneCount(0);
        pits[lastIndex].setStoneCount(0);
        pits[ownHouseIndex].setStoneCount(pits[ownHouseIndex].getStoneCount() + allCapturedStones);
    }

    private boolean isOwnHouse(Pit lastStonePit, Player currentPlayer) {
        if (lastStonePit.isHouse() && currentPlayer.getId() == lastStonePit.getOwnerId())
            return true;
        return false;
    }

    private boolean isYourOpponentsHouse(Pit lastStonePit, Player currentPlayer) {
        if (lastStonePit.isHouse() && currentPlayer.getId() != lastStonePit.getOwnerId())
            return true;
        return false;
    }

    private void decideToWhoIsTurn(Pit lastStonePit, Game game) {
        if (!isOwnHouse(lastStonePit, game.getPlayerTurn()))
            game.changePlayerTurn();
    }

    private boolean isLastStoneLandYourEmptyPit(Pit lastStonePit, Player currentPlayer) {
        if (lastStonePit.getStoneCount() == 1
                && lastStonePit.getOwnerId() == currentPlayer.getId()
                && !isOwnHouse(lastStonePit, currentPlayer))
            return true;
        return false;
    }
}
