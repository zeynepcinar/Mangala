package com.cinar.Mangala.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import static com.cinar.Mangala.TestHelper.createBoard;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link Game}
 */
public class GameTest {

    @InjectMocks
    Game game;

    Player playerNorth;
    Player playerSouth;
    Board board;

    @BeforeEach
    public void setUp() {
        board = createBoard();
    }

    /**
     *
     */
    @Test
    public void testCreateAGameSuccessfully() {
        //given

        //when
        game = new Game(board);

        //then
        assertNotNull(game);
        assertEquals(playerNorth.getId(), game.getPlayerNorth().getId());
        assertEquals(playerSouth.getId(), game.getPlayerSouth().getId());
        assertEquals(playerNorth, game.getPlayerTurn());
    }

    @Test
    public void testChangeTurnOfPlayer() {
        //given
        game = new Game(board);
        String playerTurnId = game.getPlayerTurn().getId();
        //when
        game.changePlayerTurn();

        //then
        assertNotNull(game);
        assertNotEquals(playerTurnId, game.getPlayerTurn().getId());
    }

}
