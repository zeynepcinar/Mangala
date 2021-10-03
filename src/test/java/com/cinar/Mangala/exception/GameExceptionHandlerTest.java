package com.cinar.Mangala.exception;

import com.cinar.Mangala.controller.GameController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@WebAppConfiguration
public class GameExceptionHandlerTest {

    private MockMvc mockMvc;

    @Mock
    private GameController gameController;

    @Before
    public void setUp() {
        this.mockMvc = MockMvcBuilders.standaloneSetup(gameController)
                .setControllerAdvice(new GameExceptionHandler())
                .build();
    }

    @Test
    public void catchesExceptionWhenGameNotFoundWithSpecificResponse() throws Exception {

        when(gameController.playGame("dummyId", 8)).thenThrow(new GameNotFoundException("Game with id: dummyId is not found."));

        mockMvc.perform(put("/games/{gameId}/pickup/7", "dummyId"))
                .andExpect(status().isNotFound())
                .andReturn();
    }

    @Test
    public void catchesExceptionWhenForbiddenMoveOnPitWithSpecificResponse() throws Exception {

        when(gameController.playGame("dummyId", 6)).thenThrow(new ForbiddenMoveOnPitException("You can't pick up the stone from a house pit"));

        mockMvc.perform(put("/games/{gameId}/pickup/7", "dummyId"))
                .andExpect(status().isNotFound())
                .andReturn();
    }
}


