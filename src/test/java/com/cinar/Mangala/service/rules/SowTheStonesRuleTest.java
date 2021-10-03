package com.cinar.Mangala.service.rules;

import com.cinar.Mangala.enums.PlayerType;
import com.cinar.Mangala.model.Board;
import com.cinar.Mangala.model.Game;
import org.junit.Before;
import org.junit.Test;

import static com.cinar.Mangala.TestHelper.createBoard;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SowTheStonesRuleTest {

    private SowTheStonesRule sowTheStonesRule;

    private static Board board;

    @Before
    public void setUp() {
        sowTheStonesRule = new SowTheStonesRule();
        sowTheStonesRule.next = new GameOverCheck();
        board = createBoard();
    }

    @Test
    public void shouldApplyGameRulesWithGivenPitIdSuccessfully() {
        //given
        int selectedPit = 8;
        Game game = new Game(board);

        //when
        sowTheStonesRule.apply(game, selectedPit);

        //then
        assertEquals(0, game.getBoard()[selectedPit].getStoneCount());
        assertEquals(7, game.getBoard()[selectedPit + 1].getStoneCount());
        assertEquals(7, game.getBoard()[selectedPit + 2].getStoneCount());
        assertEquals(7, game.getBoard()[selectedPit + 3].getStoneCount());
        assertEquals(7, game.getBoard()[selectedPit + 4].getStoneCount());
        assertEquals(1, game.getBoard()[selectedPit + 5].getStoneCount());
        assertEquals(7, game.getBoard()[0].getStoneCount());
        assertEquals(PlayerType.PLAYER_SOUTH, game.getPlayerTurn().getPlayerType());
    }

    @Test
    public void whenLastStoneIsOnHousePitGetAnotherTurn() {
        //given
        int selectedPit = 7;
        Game game = new Game(board);

        //when
        sowTheStonesRule.apply(game, selectedPit);

        //then
        assertEquals(0, game.getBoard()[selectedPit].getStoneCount());
        assertEquals(7, game.getBoard()[selectedPit + 1].getStoneCount());
        assertEquals(7, game.getBoard()[selectedPit + 2].getStoneCount());
        assertEquals(7, game.getBoard()[selectedPit + 3].getStoneCount());
        assertEquals(7, game.getBoard()[selectedPit + 4].getStoneCount());
        assertEquals(7, game.getBoard()[selectedPit + 5].getStoneCount());
        assertEquals(1, game.getBoard()[selectedPit + 6].getStoneCount());
        assertEquals(PlayerType.PLAYER_NORTH, game.getPlayerTurn().getPlayerType());
    }

    /*@SneakyThrows
    @Test
    public void shouldDecideToWhoIsTurnCorrectly() {
        //given
        int selectedPit = 5;
        Board board = new Board(new Player(PlayerType.PLAYER_SOUTH), new Player(PlayerType.PLAYER_NORTH));
        board.getBoard()[selectedPit].setStoneCount(3);
        Game game = new Game(board);
        Method method = MangalaRuleApplier.class.getDeclaredMethod("decideToWhoIsTurn", Pit.class, Game.class);
        method.setAccessible(true);

        //when
        method.invoke(rules, game.getBoard()[selectedPit], game);

        //then
        assertEquals(game.getPlayerTurn().getPlayerType(), PlayerType.PLAYER_SOUTH);
    }

    @SneakyThrows
    @Test
    public void shouldIsLastStoneLandYourEmptyPitFunctionWorksCorrectly() {
        //given
        int selectedPit = 8;
        Board board = new Board(new Player(PlayerType.PLAYER_SOUTH), new Player(PlayerType.PLAYER_NORTH));
        board.getBoard()[selectedPit].setStoneCount(1);
        Game game = new Game(board);
        Method method = MangalaRuleApplier.class.getDeclaredMethod("isLastStoneLandYourEmptyPit", Pit.class, Player.class);
        method.setAccessible(true);

        //when
        boolean result = (boolean) method.invoke(rules, game.getBoard()[selectedPit], game.getPlayerTurn());

        //then
        assertEquals(result, true);
    }

    @SneakyThrows
    @Test
    public void shouldCaptureOpponentsStonesAndPutOwnHouse() {
        //given
        int ownHouseIndex = 6;
        int lastIndex = 4;
        Board board = new Board(new Player(PlayerType.PLAYER_SOUTH), new Player(PlayerType.PLAYER_NORTH));
        board.getBoard()[lastIndex].setStoneCount(1);
        Game game = new Game(board);
        Method method = MangalaRuleApplier.class.getDeclaredMethod("captureOpponentsStonesAndPutOwnHouse", int.class, int.class, Pit[].class);
        method.setAccessible(true);

        //when
        method.invoke(rules, ownHouseIndex, lastIndex, game.getBoard());

        //then
        assertEquals(7, game.getBoard()[ownHouseIndex].getStoneCount());
    }*/

}
