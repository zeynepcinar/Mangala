package com.cinar.Mangala.service.rules;

import com.cinar.Mangala.exception.ForbiddenMoveOnPitException;
import com.cinar.Mangala.model.Game;
import com.cinar.Mangala.model.Pit;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class PitEligibilityRule extends MangalaRule {

    @Override
    public void apply(Game game, int selectedPitId) {
        log.debug("Check the selected pit with id {} is eligible for the move", selectedPitId);

        Pit selectedPit = game.getBoard()[selectedPitId];
        if (selectedPit.isHouse())
            throw new ForbiddenMoveOnPitException("You can't pick up the stone from a house pit");
        if (selectedPit.getStoneCount() == 0)
            throw new ForbiddenMoveOnPitException("Selected pit with id: " + selectedPitId + " is empty.");
        if (selectedPit.getOwnerId() != game.getPlayerTurn().getId())
            throw new ForbiddenMoveOnPitException("Selected pit with id: " + selectedPitId + " is not belong to player.");

        this.next.apply(game, selectedPitId);
    }
}
