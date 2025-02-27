package com.imc.rpc.ui;

import java.util.Comparator;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Stream;

public abstract class AbstractMenu<T extends MenuItem> implements Menu {
    
    private static final Action DEFAULT_ACTION = () -> System.err.print("Wrong input! Try again.\n> ");
    
    protected final Scanner scanner;
    protected final Map<Integer, Action> actionMap = new HashMap<>();

    public AbstractMenu(Scanner scanner) {
        this.scanner = scanner;
    }
    
    @Override
    public void show() {
        showMenuItems(getMenuItems());
        while (true) {
            try {
                int action = scanner.nextInt();
                actionMap.getOrDefault(action, DEFAULT_ACTION).perform();
            } catch (InputMismatchException e) {
                DEFAULT_ACTION.perform();
                scanner.next();
            }
        }
    }
    
    abstract protected T[] getMenuItems();

    protected void showMenuItems(T... menuItems) {
        Stream.of(menuItems)
                .sorted(Comparator.comparingInt(MenuItem::getOrder))
                .forEach(menuItem -> System.out.printf("%d. %s\n", menuItem.getOrder(), menuItem.getValue()));
        System.out.print("> ");
    }
}
