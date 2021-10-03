package com.cinar.Mangala.service.rules;

import com.cinar.Mangala.enums.PlayerType;
import com.cinar.Mangala.model.Game;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;

import static com.cinar.Mangala.TestHelper.createRandomGameOnLastRound;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameOverCheckTest {

    @InjectMocks
    private GameOverCheck gameOverCheckRule;

    @Before
    public void setUp() {
        gameOverCheckRule = new GameOverCheck();
    }

    /**
     * game is set as in last round
     * player south has more stones, so it should be a winner
     * should reset board
     */
    @Test
    public void checkIsGameOver() {
        //given
        int selectedPit = 8;
        Game game = createRandomGameOnLastRound();

        //when
        gameOverCheckRule.apply(game, selectedPit);

        //then
        Assert.assertEquals(PlayerType.PLAYER_NORTH, game.getWinner().getPlayerType());
        assertEquals(6, game.getBoard()[0].getStoneCount());
        assertEquals(6, game.getBoard()[1].getStoneCount());
        assertEquals(6, game.getBoard()[2].getStoneCount());
        assertEquals(6, game.getBoard()[3].getStoneCount());
        assertEquals(6, game.getBoard()[4].getStoneCount());
        assertEquals(6, game.getBoard()[5].getStoneCount());
    }

}
