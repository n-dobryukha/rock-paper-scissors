package com.imc.rpc.engine;

import com.imc.rpc.model.Result;
import com.imc.rpc.model.Symbol;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class JudgeTest {
    
    private final Judge judge = new Judge();

    @ParameterizedTest
    @MethodSource("provideResultsForCompare")
    void testGetResult(Symbol s1, Symbol s2, Result result) {
        assertEquals(result, judge.getResult(s1, s2));
    }

    private static Stream<Arguments> provideResultsForCompare() {
        return Stream.of(
                Arguments.of(Symbol.ROCK, Symbol.SCISSORS, Result.WIN),
                Arguments.of(Symbol.ROCK, Symbol.ROCK, Result.TIE),
                Arguments.of(Symbol.ROCK, Symbol.PAPER, Result.LOSE),
                Arguments.of(Symbol.PAPER, Symbol.ROCK, Result.WIN),
                Arguments.of(Symbol.PAPER, Symbol.PAPER, Result.TIE),
                Arguments.of(Symbol.PAPER, Symbol.SCISSORS, Result.LOSE),
                Arguments.of(Symbol.SCISSORS, Symbol.PAPER, Result.WIN),
                Arguments.of(Symbol.SCISSORS, Symbol.SCISSORS, Result.TIE),
                Arguments.of(Symbol.SCISSORS, Symbol.ROCK, Result.LOSE)
        );
    }
}