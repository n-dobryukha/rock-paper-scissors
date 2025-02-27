package com.imc.rpc.ui;

import com.imc.rpc.engine.Game;

import java.util.Scanner;

public class GameMenu extends AbstractMenu<GameMenuItem> {
    
    private final Game game;

    public GameMenu(Scanner scanner, Game game, Menu mainMenu) {
        super(scanner);
        this.game = game;
        actionMap.put(GameMenuItem.CONTINUE.getOrder(), this::playRound);
        actionMap.put(GameMenuItem.STATISTIC.getOrder(), this::showStatistic);
        actionMap.put(GameMenuItem.EXIT.getOrder(), mainMenu::show);
    }

    @Override
    protected GameMenuItem[] getMenuItems() {
        return GameMenuItem.values();
    }

    @Override
    public void show() {
        game.start();
        playRound();
    }
    
    private void playRound() {
        game.playRound();
        super.show();
    }
    
    private void showStatistic() {
        game.showStatistic();
        super.show();
    }
}
