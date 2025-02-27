package com.imc.rpc.model;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class SymbolComparatorTest {
    
    private final SymbolComparator comparator = new SymbolComparator();

    @ParameterizedTest
    @MethodSource("provideSymbolsForCompare")
    void testCompare(Symbol s1, Symbol s2, int result) {
        assertEquals(result, comparator.compare(s1, s2));
    }
    
    private static Stream<Arguments> provideSymbolsForCompare() {
        return Stream.of(
                Arguments.of(Symbol.ROCK, Symbol.SCISSORS, 1),
                Arguments.of(Symbol.ROCK, Symbol.ROCK, 0),
                Arguments.of(Symbol.ROCK, Symbol.PAPER, -1),
                Arguments.of(Symbol.PAPER, Symbol.ROCK, 1),
                Arguments.of(Symbol.PAPER, Symbol.PAPER, 0),
                Arguments.of(Symbol.PAPER, Symbol.SCISSORS, -1),
                Arguments.of(Symbol.SCISSORS, Symbol.PAPER, 1),
                Arguments.of(Symbol.SCISSORS, Symbol.SCISSORS, 0),
                Arguments.of(Symbol.SCISSORS, Symbol.ROCK, -1)
        );
    }
}