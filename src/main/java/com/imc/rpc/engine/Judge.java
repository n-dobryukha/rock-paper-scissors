package com.imc.rpc.engine;

import com.imc.rpc.model.Result;
import com.imc.rpc.model.Symbol;
import com.imc.rpc.model.SymbolComparator;

public class Judge {
    
    private static final SymbolComparator comparator = new SymbolComparator();
    
    public Result getResult(Symbol symbol1, Symbol symbol2) {
        int compareResult = comparator.compare(symbol1, symbol2);
        return Result.getByValue(compareResult);
    }
}
