package com.cinar.Mangala.service.rules;

import com.cinar.Mangala.model.Game;

public abstract class MangalaRule {

    protected MangalaRule next;

    public abstract void apply(Game game, int selectedPitId);

    public MangalaRule setNext(MangalaRule next) {
        this.next = next;
        return next;
    }
}
