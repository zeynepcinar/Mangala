package com.cinar.Mangala.exception;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class GameNotFoundExceptionTest {
    @Test
    public void testGameNotFoundException() {
        GameNotFoundException givenGameNotFoundException = new GameNotFoundException("Game with id 1 is not found");
        Assert.assertEquals("Game with id 1 is not found", givenGameNotFoundException.getMessage());
    }
}

