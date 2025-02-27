package com.imc.rpc.engine;

import com.imc.rpc.model.Result;
import com.imc.rpc.model.Symbol;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Map;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class GameTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    
    @Mock
    private Scanner scanner;

    private Player playerOne;
    private Player playerTwo;
    
    private Game game;

    @BeforeEach
    void setUp() throws NoSuchFieldException, IllegalAccessException {
        playerOne = new InputReaderPlayer("TEST_PLAYER_ONE", scanner);
        playerTwo = new InputReaderPlayer("TEST_PLAYER_TWO", scanner);

        when(scanner.nextInt()).thenReturn(Symbol.ROCK.getOrder(), Symbol.SCISSORS.getOrder());
        game = new Game(playerOne, playerTwo);
        game.start();
        game.playRound();
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }
    
    @AfterEach
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
    }

    @Test
    void testPlayerOneWin() {
        
        Map<Result, Integer> statisticOne = game.getStatistic(playerOne);
        assertNotNull(statisticOne);
        assertFalse(statisticOne.isEmpty());
        assertEquals(1, statisticOne.get(Result.WIN));
        assertNull(statisticOne.get(Result.TIE));
        assertNull(statisticOne.get(Result.LOSE));
        Map<Result, Integer> statisticTwo = game.getStatistic(playerTwo);
        assertNotNull(statisticTwo);
        assertFalse(statisticTwo.isEmpty());
        assertNull(statisticTwo.get(Result.WIN));
        assertNull(statisticTwo.get(Result.TIE));
        assertEquals(1, statisticTwo.get(Result.LOSE));
    }

    @Test
    void testShowStatisticForPlayerOne() {
        game.showStatistic(playerOne);
        assertEquals("LOSE  : 0\nTIE   : 0\nWIN   : 1\n", outContent.toString());
    }

    @Test
    void testShowStatisticForPlayerTwo() {
        game.showStatistic(playerTwo);
        assertEquals("LOSE  : 1\nTIE   : 0\nWIN   : 0\n", outContent.toString());
    }

    @Test
    void testShowStatisticForAll() {
        game.showStatistic();
        assertEquals("       TEST_PLAYER_ONE TEST_PLAYER_TWO\n" +
                "LOSE :               0               1\n" +
                "TIE  :               0               0\n" +
                "WIN  :               1               0\n", outContent.toString());
    }
}