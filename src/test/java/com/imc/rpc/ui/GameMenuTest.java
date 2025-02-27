package com.imc.rpc.ui;

import com.imc.rpc.engine.Game;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class GameMenuTest extends AbstractUiTest {

    @Mock
    private Scanner scanner;
    @Mock
    private Game game;
    @Mock
    private MainMenu mainMenu;

    @InjectMocks
    private GameMenu menu;

    @Test
    void testShow() {
        menu.showMenuItems(menu.getMenuItems());
        assertEquals("1. Continue\n" +
                "2. Statistic\n" +
                "3. Exit\n" +
                "> ", outContent.toString());
    }
}