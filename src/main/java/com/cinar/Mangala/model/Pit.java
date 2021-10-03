package com.cinar.Mangala.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Pit {

    private final int pitId;
    private int stoneCount;
    private String ownerId;
    private boolean isHouse;

    @Override
    public String toString() {
        return pitId + ": " + stoneCount;
    }
}
