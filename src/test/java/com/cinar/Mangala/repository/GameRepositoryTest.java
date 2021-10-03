package com.cinar.Mangala.repository;

import com.cinar.Mangala.TestHelper;
import com.cinar.Mangala.model.Game;
import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Unit tests for {@link GameRepository}
 */
@RunWith(SpringRunner.class)
public class GameRepositoryTest {

    @InjectMocks
    private GameRepository repository;

    @BeforeEach
    public void setUp() {
        repository = new GameRepository();
    }

    @Test
    public void gameIsSavedSuccessfully() {
        //given
        Game game = TestHelper.createGame();

        //when
        Game returnedGame = repository.save(game.getGameId(), game);

        //then
        Assert.assertNotNull(returnedGame);
        Assert.assertEquals(game.getGameId(), returnedGame.getGameId());
    }

    @Test
    public void gameIsFoundSuccessfully() {
        //given
        Game game = TestHelper.createGame();
        repository.save(game.getGameId(), game);

        //when
        Game returnedGame = repository.getGame(game.getGameId());

        //then
        Assert.assertNotNull(returnedGame);
        Assert.assertEquals(game.getGameId(), returnedGame.getGameId());
    }
}