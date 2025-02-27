package com.imc.rpc.model;

import java.util.Map;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public enum Result {
    WIN(1, "You win. Congrats!"),
    LOSE(-1, "You lose. Cheer up!"),
    TIE(0, "It's a tie. Try again!");
    
    private static final Map<Integer, Result> lookup = Stream.of(Result.values())
            .collect(Collectors.toMap(Result::getValue, Function.identity()));
    
    private final int value;
    private final String message;

    Result(int value, String message) {
        this.value = value;
        this.message = message;
    }

    public int getValue() {
        return value;
    }

    public String getMessage() {
        return message;
    }

    public static Result getByValue(int value) {
        return Optional.ofNullable(lookup.get(value)).orElseThrow(() -> new IllegalArgumentException("Illegal value: " + value));
    }
}
