package com.imc.rpc.model;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

import java.util.EnumMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {
    private static final Map<Result, Integer> resultValues = new EnumMap<Result, Integer>(Result.class){{
        put(Result.WIN, 1);
        put(Result.TIE, 0);
        put(Result.LOSE, -1);
    }};

    private static final Map<Result, String> resultMessages = new EnumMap<Result, String>(Result.class){{
        put(Result.WIN, "You win. Congrats!");
        put(Result.TIE, "It's a tie. Try again!");
        put(Result.LOSE, "You lose. Cheer up!");
    }};

    @ParameterizedTest
    @EnumSource(Result.class)
    void testGetValue(Result result) {
        assertEquals(resultValues.get(result), result.getValue());
    }

    @ParameterizedTest
    @EnumSource(Result.class)
    void testGetMessage(Result result) {
        assertEquals(resultMessages.get(result), result.getMessage());
    }

    @ParameterizedTest
    @EnumSource(Result.class)
    void testGetByValue_OK(Result result) {
        assertEquals(result, Result.getByValue(result.getValue()));
    }

    @Test
    void testGetByValue_NotFound() {
        assertThrows(IllegalArgumentException.class, () -> Result.getByValue(Integer.MAX_VALUE));
    }
}