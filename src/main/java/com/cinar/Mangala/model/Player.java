package com.cinar.Mangala.model;

import com.cinar.Mangala.enums.PlayerType;
import lombok.Getter;

import java.util.UUID;

@Getter
public class Player {

    private String id;
    private PlayerType playerType;

    public Player(PlayerType playerType) {
        this.id = UUID.randomUUID().toString();
        this.playerType = playerType;
    }

}

