package com.imc.rpc.engine;

import com.imc.rpc.model.Result;
import com.imc.rpc.model.Symbol;
import com.imc.rpc.ui.ChoiceMenu;
import com.imc.rpc.ui.Menu;

import java.util.Collections;
import java.util.Comparator;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Stream;

public class Game {
    
    private final Player playerOne;
    private final Player playerTwo;
    private final Judge judge;
    private final Map<Player, Map<Result, Integer>> statistic;
    private final Menu choiceMenu;

    public Game(Player playerOne, Player playerTwo) {
        this.playerOne = playerOne;
        this.playerTwo = playerTwo;
        this.judge = new Judge();
        this.statistic = new HashMap<>(2);
        this.choiceMenu = new ChoiceMenu();
    }

    public void start() {
        statistic.clear();
    }
    
    public Map<Result, Integer> getStatistic(Player player) {
        return statistic.getOrDefault(player, Collections.emptyMap());
    }

    public void showStatistic() {
        Map<Result, Integer> statisticOne = this.statistic.getOrDefault(playerOne, Collections.emptyMap());
        Map<Result, Integer> statisticTwo = this.statistic.getOrDefault(playerTwo, Collections.emptyMap());
        
        String playerOneName = playerOne.getName();
        int playerOneNameLength = playerOneName.length();
        String playerTwoName = playerTwo.getName();
        int playerTwoNameLength = playerTwoName.length();
        
        System.out.printf("%" + (playerOneNameLength + 7) + "s %s\n", playerOneName, playerTwoName);
        Stream.of(Result.values())
                .sorted(Comparator.comparingInt(Result::getValue))
                .forEach(result -> System.out.printf("%-5s: %" +  playerOneNameLength + "s %" + playerTwoNameLength + "s\n", result,
                    statisticOne.getOrDefault(result, 0),
                    statisticTwo.getOrDefault(result, 0)));
    }
    
    public void showStatistic(Player player) {
        Map<Result, Integer> statistic = this.statistic.getOrDefault(player, Collections.emptyMap());

        Stream.of(Result.values())
                .sorted(Comparator.comparingInt(Result::getValue))
                .forEach(result -> System.out.printf("%-6s: %d\n", result, statistic.getOrDefault(result, 0)));
    }
    
    public void playRound() {
        choiceMenu.show();
        Symbol symbolOne = playerOne.getSymbol();
        Symbol symbolTwo = playerTwo.getSymbol();
        Result resultOne = judge.getResult(symbolOne, symbolTwo);
        System.out.printf("%s have chosen %s, %s has chosen %s. %s\n",
                playerOne.getName(), symbolOne, playerTwo.getName(), symbolTwo, resultOne.getMessage());
        saveStatistic(playerOne, resultOne);
        Result resultTwo = judge.getResult(symbolTwo, symbolOne);
        saveStatistic(playerTwo, resultTwo);
    }
    
    private void saveStatistic(Player player, Result result) {
        statistic.computeIfAbsent(player, k -> new EnumMap<>(Result.class)).merge(result, 1, Integer::sum);
    }
    
}
