package com.cinar.Mangala.service.rules;

import com.cinar.Mangala.service.MangalaRuleApplier;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Unit tests for {@link MangalaRuleApplier}
 */
public class GameRuleTest {

/*
    @InjectMocks
    private MangalaRuleApplier rules;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void shouldThrowExceptionWhenSelectedPitIsEmpty() {
        //given
        int selectedPit = 3;
        Board board = new Board(new Player(PlayerType.PLAYER_SOUTH), new Player(PlayerType.PLAYER_NORTH));
        board.getBoard()[selectedPit].setStoneCount(0);
        Game game = new Game(board);

        //when

        //then
        IllegalMoveOnPitException thrown = Assertions.assertThrows(IllegalMoveOnPitException.class, () -> {
            rules.checkPitEligibility(game, selectedPit);
        });
        assertTrue(thrown.getMessage().contains("Selected pit with id:"));
    }

    @Test
    public void shouldThrowExceptionWhenSelectedPitIsHousePit() {
        //given
        int selectedPit = 6;
        Board board = new Board(new Player(PlayerType.PLAYER_SOUTH), new Player(PlayerType.PLAYER_NORTH));
        board.getBoard()[selectedPit].setStoneCount(3);
        Game game = new Game(board);

        //when

        //then
        IllegalMoveOnPitException thrown = Assertions.assertThrows(IllegalMoveOnPitException.class, () -> {
            rules.checkPitEligibility(game, selectedPit);
        });
        assertTrue(thrown.getMessage().contains("You can't pick up the stone from a house pit :"));
    }


    /**
     * current player is default Player_North and Player_North has pits with index between 7-13.
     */
    /*
    @Test
    public void shouldThrowExceptionWhenSelectedPitIsNotBelongToCurrentPlayer() {
        //given
        int selectedPit = 5;
        Board board = new Board(new Player(PlayerType.PLAYER_SOUTH), new Player(PlayerType.PLAYER_NORTH));
        board.getBoard()[selectedPit].setStoneCount(3);
        Game game = new Game(board);

        //when

        //then
        IllegalMoveOnPitException thrown = Assertions.assertThrows(IllegalMoveOnPitException.class, () -> {
            rules.checkPitEligibility(game, selectedPit);
        });
        assertTrue(thrown.getMessage().contains("Selected pit with id"));
    }

    @Test
    public void shouldApplyGameRulesWithGivenPitIdSuccessfully() {
        //given
        int selectedPit = 8;
        Board board = new Board(new Player(PlayerType.PLAYER_SOUTH), new Player(PlayerType.PLAYER_NORTH));
        Game game = new Game(board);

        //when
        rules.applyGameRules(game, selectedPit);

        //then
        Assertions.assertEquals(0, game.getBoard()[selectedPit].getStoneCount());
    }

    @SneakyThrows
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
    }
*/
}
