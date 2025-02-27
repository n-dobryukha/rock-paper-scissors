package com.imc.rpc.engine;

import com.imc.rpc.model.Symbol;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;

public class InputReaderPlayer extends RandomPlayer {
    
    private final Scanner scanner;

    public InputReaderPlayer(String name, Scanner scanner) {
        super(name);
        this.scanner = scanner;
    }

    @Override
    public Symbol getSymbol() {
        int choice = 0;
        try {
            choice = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.err.println("Wrong input. The symbol will be randomized.");
        }
        return Optional.ofNullable(Symbol.getByOrder(choice))
                .orElseGet(super::getSymbol);
    }
}
