package com.cinar.Mangala.controller;

import com.cinar.Mangala.controller.response.GameResponse;
import com.cinar.Mangala.model.Game;
import com.cinar.Mangala.service.GameService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RestController
@RequestMapping(value = "/game")
public class GameController {

    private final GameService service;

    @Autowired
    public GameController(GameService service) {
        this.service = service;
    }

    @ApiOperation(value = "Creates and starts a new game")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/start")
    public ResponseEntity<GameResponse> startGame() {
        Game game = service.startGame();
        log.info("Game instance created with id {}", game.getGameId());
        GameResponse gameResponse = new GameResponse(game.getGameId(), game.getStatus());
        return ResponseEntity.status(HttpStatus.CREATED).body(gameResponse);
    }

    @ApiOperation(value = "Take stones from selected pitId in the selected gameId and sow them to pits in the " +
            "counter-clock wise direction returns the updated version of game")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{gameId}/pickup/{pitId}")
    public ResponseEntity<Game> playGame(@PathVariable final String gameId, @PathVariable final int pitId) {
        log.info("Player is about to make move on pit with id {}", pitId);
        Game game = service.makeAMove(gameId, pitId);
        /*final Map<Integer, String> status = game.getBoard().getPits().stream()
                .collect(Collectors.toMap(Pit::getId, value -> Integer.toString(value.getStoneCount())));
        final GameResponse gameResponse = new GameResponse(game.getId(), getUrl(game.getId()), status);*/
        return ResponseEntity.status(HttpStatus.OK).body(game);
    }

    @ApiOperation(value = "Get all games")
    @ResponseStatus(HttpStatus.OK)
    @PostMapping("/getAll")
    public ResponseEntity<List<GameResponse>> getAllGames() {
        log.info("Getting all games.");
        List<Game> games = service.getAllGames();
        List<GameResponse> gameResponses = games.stream()
                .map(game -> new GameResponse(game.getGameId(), game.getStatus()))
                .collect(Collectors.toList());
        return ResponseEntity.status(HttpStatus.OK).body(gameResponses);
    }
}
