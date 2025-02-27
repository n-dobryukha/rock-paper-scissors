package com.imc.rpc.model;

import java.util.Comparator;
import java.util.EnumMap;
import java.util.Map;

public class SymbolComparator implements Comparator<Symbol> {
    
    private static final Map<Symbol, Symbol> rulesMap = new EnumMap<Symbol, Symbol>(Symbol.class){{
        put(Symbol.ROCK, Symbol.SCISSORS);
        put(Symbol.PAPER, Symbol.ROCK);
        put(Symbol.SCISSORS, Symbol.PAPER);
    }};
    
    @Override
    public int compare(Symbol s1, Symbol s2) {
        return s1 == s2 ? Result.TIE.getValue() : rulesMap.get(s1) == s2 ? Result.WIN.getValue() : Result.LOSE.getValue();
    }
}
