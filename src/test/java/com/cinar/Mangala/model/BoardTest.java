package com.cinar.Mangala.model;

import com.cinar.Mangala.enums.PlayerType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit tests for {@link Board}
 */
public class BoardTest {

    @InjectMocks
    Board board;

    private int NUM_OF_PITS = 14;
    private int REGULAR_PIT_STONE_COUNT = 6;
    private int HOUSE_PIT_INITIAL_STONE_COUNT = 0;
    Player playerNorth;
    Player playerSouth;

    @BeforeEach
    public void setUp() {
        playerNorth = new Player(PlayerType.PLAYER_NORTH);
        playerSouth = new Player(PlayerType.PLAYER_SOUTH);
    }

    /**
     * Pits with index 0-6 should belong to player south / Pits with index 7-13 should belong to player north.
     */
    @Test
    public void testCreateAndInitializeBoard() {
        //given

        //when
        board = new Board(playerSouth, playerNorth);

        //then
        assertNotNull(board.getBoard());
        assertEquals(NUM_OF_PITS, board.getBoard().length);
        assertEquals(playerSouth.getId(), board.getBoard()[0].getOwnerId());
        assertEquals(playerSouth.getId(), board.getBoard()[3].getOwnerId());
        assertEquals(playerSouth.getId(), board.getBoard()[6].getOwnerId());
        assertEquals(playerNorth.getId(), board.getBoard()[7].getOwnerId());
        assertEquals(playerNorth.getId(), board.getBoard()[10].getOwnerId());
        assertEquals(playerNorth.getId(), board.getBoard()[13].getOwnerId());
    }

    /**
     * Initial count of the normal pits should be 6, house pits should be 0
     */
    @Test
    public void testStoneCount() {
        //given
        int[] expectedPitCounts = new int[NUM_OF_PITS];
        Arrays.fill(expectedPitCounts, REGULAR_PIT_STONE_COUNT);
        expectedPitCounts[6] = expectedPitCounts[13] = HOUSE_PIT_INITIAL_STONE_COUNT;
        boolean isExpectedPitCounts = true;
        //when
        board = new Board(playerSouth, playerNorth);

        //then
        for (int i = 0; i < board.getBoard().length; i++) {
            if (expectedPitCounts[i] != board.getBoard()[i].getStoneCount())
                isExpectedPitCounts = false;
        }

        assertNotNull(board.getBoard());
        assertEquals(NUM_OF_PITS, board.getBoard().length);
        assertTrue(isExpectedPitCounts);
    }

}
