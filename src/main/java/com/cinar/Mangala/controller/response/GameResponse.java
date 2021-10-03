package com.cinar.Mangala.controller.response;

import com.cinar.Mangala.enums.GameStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class GameResponse {

    private String gameId;

    private GameStatus status;

}
