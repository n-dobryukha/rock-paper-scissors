package com.imc.rpc.ui;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ChoiceMenuTest extends AbstractUiTest {
    
    private final ChoiceMenu menu = new ChoiceMenu();

    @Test
    void testShow() {
        menu.show();
        assertEquals("1. ROCK\n" +
                "2. PAPER\n" +
                "3. SCISSORS\n" +
                "0. RANDOM\n" +
                "Choose your symbol> ", outContent.toString());
    }
}