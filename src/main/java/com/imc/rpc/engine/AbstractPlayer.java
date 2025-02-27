package com.imc.rpc.engine;

public abstract class AbstractPlayer implements Player {
    private final String name;

    public AbstractPlayer(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
