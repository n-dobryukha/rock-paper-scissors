package com.imc.rpc.ui;

public enum MainMenuItem implements MenuItem {
    RULES(1, "Show the rules"),
    START(2, "Start new game"),
    EXIT(3, "Exit");
    
    private final int order;
    private final String value;

    MainMenuItem(int order, String value) {
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
