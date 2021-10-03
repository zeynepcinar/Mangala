package com.cinar.Mangala.exception;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
@SpringBootTest
public class ForbiddenMoveOnPitExceptionTest {
    @Test
    public void testForbiddenMoveOnPitException() {
        ForbiddenMoveOnPitException givenGameNotFoundException = new ForbiddenMoveOnPitException("You can't pick up the stone from a house pit");
        Assert.assertEquals("You can't pick up the stone from a house pit", givenGameNotFoundException.getMessage());
    }
}
