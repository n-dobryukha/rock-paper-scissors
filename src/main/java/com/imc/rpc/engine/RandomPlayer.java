package com.imc.rpc.engine;

import com.imc.rpc.model.Symbol;

import java.util.Random;

public class RandomPlayer extends AbstractPlayer {
    
    private final Random random = new Random();

    public RandomPlayer(String name) {
        super(name);
    }

    @Override
    public Symbol getSymbol() {
        int idx = random.nextInt(Symbol.values().length);
        return Symbol.values()[idx];
    }
}
