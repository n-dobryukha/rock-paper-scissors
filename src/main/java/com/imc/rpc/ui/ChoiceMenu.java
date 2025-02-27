package com.imc.rpc.ui;

import com.imc.rpc.model.Symbol;

import java.util.Comparator;
import java.util.stream.Stream;

public class ChoiceMenu implements Menu {
    
    @Override
    public void show() {
        Stream.of(Symbol.values())
                .sorted(Comparator.comparingInt(MenuItem::getOrder))
                .forEach(menuItem -> System.out.printf("%d. %s\n", menuItem.getOrder(), menuItem.getValue()));
        System.out.printf("%d. %s\n", 0, "RANDOM");
        System.out.print("Choose your symbol> ");
    }
}
