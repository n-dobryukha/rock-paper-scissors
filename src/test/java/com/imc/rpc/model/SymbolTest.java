package com.imc.rpc.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class SymbolTest {

    private static final Map<Symbol, Integer> symbolOrders = new EnumMap<Symbol, Integer>(Symbol.class){{
        put(Symbol.ROCK, 1);
        put(Symbol.PAPER, 2);
        put(Symbol.SCISSORS, 3);
    }};

    @ParameterizedTest
    @EnumSource(Symbol.class)
    void testGetOrder(Symbol symbol) {
        assertEquals(symbolOrders.get(symbol), symbol.getOrder());
    }

    @ParameterizedTest
    @EnumSource(Symbol.class)
    void testGetValue(Symbol symbol) {
        assertEquals(symbol.name(), symbol.getValue());
    }

    @ParameterizedTest
    @EnumSource(Symbol.class)
    void testGetByOrder(Symbol symbol) {
        assertEquals(symbol, Symbol.getByOrder(symbol.getOrder()));
    }
}