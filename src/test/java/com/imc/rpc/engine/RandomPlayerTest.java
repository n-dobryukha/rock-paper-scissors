package com.imc.rpc.engine;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RandomPlayerTest {
    
    protected final String TEST_NAME = "TEST";

    private final Player player = new RandomPlayer(TEST_NAME);
    
    @Test
    void getName() {
        assertEquals(TEST_NAME, player.getName());
    }

    @Test
    void testGetSymbol() {
        assertNotNull(player.getSymbol());
    }
}