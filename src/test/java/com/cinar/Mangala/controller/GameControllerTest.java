package com.cinar.Mangala.controller;

import com.cinar.Mangala.controller.response.GameResponse;
import com.cinar.Mangala.enums.GameStatus;
import com.cinar.Mangala.model.Game;
import com.cinar.Mangala.service.GameService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.cinar.Mangala.TestHelper.createGame;
import static com.cinar.Mangala.TestHelper.createMultipleGames;
import static org.mockito.Mockito.when;


public class GameControllerTest {

    @InjectMocks
    private GameController gameController;

    @Mock
    private GameService gameServiceMock;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateGame() {
        //given
        Game game = createGame();
        game.setStatus(GameStatus.CREATED);
        when(gameServiceMock.startGame()).thenReturn(game);

        //when
        ResponseEntity<GameResponse> response = gameController.startGame();

        //then
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        Assert.assertEquals(GameStatus.CREATED, response.getBody().getStatus());
        Assert.assertEquals(HttpStatus.CREATED, response.getStatusCode());
    }

    @Test
    public void testPlayGame() {
        //given
        Game game = createGame();
        int selectedPitId = 8;
        game.setStatus(GameStatus.ONGOING);
        when(gameServiceMock.makeAMove(game.getGameId(), selectedPitId)).thenReturn(game);

        //when
        ResponseEntity<Game> response = gameController.playGame(game.getGameId(), selectedPitId);

        //then
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        Assert.assertEquals(game, response.getBody());
        Assert.assertEquals(GameStatus.ONGOING, response.getBody().getStatus());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

    @Test
    public void testGetAllGames() {
        //given
        List<Game> games = createMultipleGames();
        when(gameServiceMock.getAllGames()).thenReturn(games);

        //when
        ResponseEntity<List<GameResponse>> response = gameController.getAllGames();

        //then
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getBody());
        Assert.assertEquals(2, response.getBody().size());
        Assert.assertEquals(HttpStatus.OK, response.getStatusCode());
    }

}