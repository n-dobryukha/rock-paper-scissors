package com.imc.rpc;

import com.imc.rpc.ui.MainMenu;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        MainMenu mainMenu = new MainMenu(scanner);
        mainMenu.show();
    }
    
    
}
