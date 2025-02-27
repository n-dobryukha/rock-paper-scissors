package com.imc.rpc.ui;

import com.imc.rpc.engine.Game;
import com.imc.rpc.engine.InputReaderPlayer;
import com.imc.rpc.engine.Player;
import com.imc.rpc.engine.RandomPlayer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class MainMenu extends AbstractMenu<MainMenuItem> {
    
    private static final String RULES_FILE_NAME = "/rules.txt";
    
    public MainMenu(Scanner scanner) {
        super(scanner);
        actionMap.put(MainMenuItem.RULES.getOrder(), this::showRules);
        actionMap.put(MainMenuItem.START.getOrder(), this::startGame);
        actionMap.put(MainMenuItem.EXIT.getOrder(), () -> System.exit(0));
    }

    @Override
    protected MainMenuItem[] getMenuItems() {
        return MainMenuItem.values();
    }

    private void startGame() {
        Player human = new InputReaderPlayer("You", scanner);
        Player computer = new RandomPlayer("Computer");

        Game game = new Game(human, computer);
        GameMenu gameMenu = new GameMenu(scanner, game, this);
        gameMenu.show();
    }
    
    private void showRules() {
        try(InputStream in = getClass().getResourceAsStream(RULES_FILE_NAME);
            BufferedReader reader = new BufferedReader(new InputStreamReader(in))) {
            for (String line; (line = reader.readLine()) != null;) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.err.printf("File %s is not found.", RULES_FILE_NAME);
        }
        System.out.println();
        show();
    }
}
