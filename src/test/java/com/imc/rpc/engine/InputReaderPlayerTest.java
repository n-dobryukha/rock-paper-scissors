package com.imc.rpc.engine;

import com.imc.rpc.model.Symbol;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.InputMismatchException;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class InputReaderPlayerTest extends RandomPlayerTest {
    
    private Scanner scanner;
    private Player player;

    @BeforeEach
    void setUp() {
        scanner = mock(Scanner.class);
        player = new InputReaderPlayer(TEST_NAME, scanner);
    }

    @ParameterizedTest
    @EnumSource(Symbol.class)
    void testGetSymbol_OK(Symbol symbol) {
        when(scanner.nextInt()).thenReturn(symbol.getOrder());
        assertEquals(symbol, player.getSymbol());
    }

    @Test
    void testGetSymbol_Random_1() {
        when(scanner.nextInt()).thenReturn(Integer.MAX_VALUE);
        assertNotNull(player.getSymbol());
    }

    @Test
    void testGetSymbol_Random_2() {
        when(scanner.nextInt()).thenThrow(new InputMismatchException());
        assertNotNull(player.getSymbol());
    }
}