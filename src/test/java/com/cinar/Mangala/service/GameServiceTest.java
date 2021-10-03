package com.cinar.Mangala.service;

import com.cinar.Mangala.enums.GameStatus;
import com.cinar.Mangala.enums.PlayerType;
import com.cinar.Mangala.exception.GameNotFoundException;
import com.cinar.Mangala.model.Board;
import com.cinar.Mangala.model.Game;
import com.cinar.Mangala.model.Player;
import com.cinar.Mangala.repository.GameRepository;
import org.junit.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static com.cinar.Mangala.TestHelper.createBoard;
import static com.cinar.Mangala.TestHelper.createMultipleGames;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

/**
 * Unit tests for {@link GameServiceImpl}
 */
public class GameServiceTest {

    @InjectMocks
    private GameServiceImpl gameService;

    @Mock
    private GameRepository gameRepositoryMock;

    @Mock
    private MangalaRuleApplier ruleApplier;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateGameAndReturnGame() {
        //given
        Board board = createBoard();
        Game expectedGame = new Game(board);
        when(gameRepositoryMock.save(anyString(), any())).thenReturn(expectedGame);

        //when
        Game actualGame = gameService.startGame();

        //then
        Assert.assertNotNull(actualGame);
        Assert.assertEquals(expectedGame, actualGame);
        verify(gameRepositoryMock, times(1)).save(anyString(), any(Game.class));
    }

    @Test
    public void testMakeAMoveAndReturnGame() {
        //given
        int selectedPitId = 8;
        Board board = new Board(new Player(PlayerType.PLAYER_SOUTH), new Player(PlayerType.PLAYER_NORTH));
        Game game = new Game(board);
        when(gameRepositoryMock.getGame(game.getGameId())).thenReturn(game);

        //when
        Game actualGame = gameService.makeAMove(game.getGameId(), selectedPitId);

        //then
        Assert.assertNotNull(actualGame);
        verify(gameRepositoryMock, times(1)).getGame(game.getGameId());
        verify(ruleApplier, times(1)).applyRules(game, selectedPitId);
        Assert.assertEquals(GameStatus.ONGOING, actualGame.getStatus());
    }

    @Test()
    public void throwGameNotFoundExceptionWhenGameIsNotInGameRepository() {
        //given

        //when
        Assertions.assertThrows(GameNotFoundException.class, () -> {
            gameService.makeAMove(any(), 8);
        });

        //then
        verify(gameRepositoryMock, times(1)).getGame(any());
    }

    @Test()
    public void testGetAllGames() {
        //given
        when(gameRepositoryMock.getAllGames()).thenReturn(createMultipleGames());

        //when
        List<Game> actualGames = gameService.getAllGames();

        //then
        Assert.assertNotNull(actualGames);
        Assert.assertEquals(2, actualGames.size());
    }

}