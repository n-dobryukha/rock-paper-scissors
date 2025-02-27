package com.imc.rpc.model;

import com.imc.rpc.ui.MenuItem;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Symbol implements MenuItem {
    ROCK(1), PAPER(2), SCISSORS(3);

    private static final Map<Integer, Symbol> lookup = Stream.of(Symbol.values())
            .collect(Collectors.toMap(Symbol::getOrder, Function.identity()));

    private final int order;

    Symbol(int order) {
        this.order = order;
    }

    @Override
    public int getOrder() {
        return this.order;
    }

    @Override
    public String getValue() {
        return this.name();
    }


    public static Symbol getByOrder(int value) {
        return lookup.get(value);
    }
}
