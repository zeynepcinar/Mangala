package com.cinar.Mangala.service.rules;

import com.cinar.Mangala.exception.ForbiddenMoveOnPitException;
import com.cinar.Mangala.model.Board;
import com.cinar.Mangala.model.Game;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static com.cinar.Mangala.TestHelper.createBoard;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PitEligibilityRuleTest {

    private PitEligibilityRule pitEligibilityRule;

    @Before
    public void setUp() {
        pitEligibilityRule = new PitEligibilityRule();
    }

    @Test
    public void shouldThrowExceptionWhenSelectedPitIsEmpty() {
        //given
        int selectedPit = 3;
        Board board = createBoard();
        board.getBoard()[selectedPit].setStoneCount(0);
        Game game = new Game(board);

        //when
        ForbiddenMoveOnPitException thrown = Assertions.assertThrows(ForbiddenMoveOnPitException.class, () -> {
            pitEligibilityRule.apply(game, selectedPit);
        });

        //then
        assertTrue(thrown.getMessage().contains("is empty."));
    }

    @Test
    public void shouldThrowExceptionWhenSelectedPitIsHousePit() {
        //given
        int selectedPit = 6;
        Board board = createBoard();
        board.getBoard()[selectedPit].setStoneCount(3);
        Game game = new Game(board);

        //when
        ForbiddenMoveOnPitException thrown = Assertions.assertThrows(ForbiddenMoveOnPitException.class, () -> {
            pitEligibilityRule.apply(game, selectedPit);
        });

        //then
        assertTrue(thrown.getMessage().contains("You can't pick up the stone from a house pit"));
    }


    /**
     * current player is default Player_North and Player_North has pits with index between 7-13.
     */

    @Test
    public void shouldThrowExceptionWhenSelectedPitIsNotBelongToCurrentPlayer() {
        //given
        int selectedPit = 5;
        Board board = createBoard();
        board.getBoard()[selectedPit].setStoneCount(3);
        Game game = new Game(board);

        //when
        ForbiddenMoveOnPitException thrown = Assertions.assertThrows(ForbiddenMoveOnPitException.class, () -> {
            pitEligibilityRule.apply(game, selectedPit);
        });

        //then
        assertTrue(thrown.getMessage().contains("is not belong to player."));
    }

}
