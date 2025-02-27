package com.imc.rpc.ui;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
class MainMenuTest extends AbstractUiTest {

    @Mock
    private Scanner scanner;
    
    @InjectMocks
    private MainMenu menu;
    
    @Test
    void testShow() {
        menu.showMenuItems(menu.getMenuItems());
        assertEquals("1. Show the rules\n" +
                "2. Start new game\n" +
                "3. Exit\n" +
                "> ", outContent.toString());
    }
}