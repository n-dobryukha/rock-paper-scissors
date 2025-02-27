package com.imc.rpc.ui;

public enum GameMenuItem implements MenuItem {
    CONTINUE(1, "Continue"),
    STATISTIC(2, "Statistic"),
    EXIT(3, "Exit");

    private final int order;
    private final String value;

    GameMenuItem(int order, String value) {
        this.order = order;
        this.value = value;
    }
    
    @Override
    public int getOrder() {
        return this.order;
    }

    @Override
    public String getValue() {
        return this.value;
    }
}
