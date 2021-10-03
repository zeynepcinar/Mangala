package com.cinar.Mangala.service;

import com.cinar.Mangala.model.Game;
import com.cinar.Mangala.service.rules.GameOverCheck;
import com.cinar.Mangala.service.rules.MangalaRule;
import com.cinar.Mangala.service.rules.PitEligibilityRule;
import com.cinar.Mangala.service.rules.SowTheStonesRule;
import org.springframework.stereotype.Component;

@Component
public class MangalaRuleApplier {

    private final MangalaRule chain;

    public MangalaRuleApplier() {

        chain = new PitEligibilityRule();
        chain.setNext(new SowTheStonesRule())
                .setNext(new GameOverCheck());

    }

    public void applyRules(Game game, int pitId) {
        this.chain.apply(game, pitId);
    }

}


