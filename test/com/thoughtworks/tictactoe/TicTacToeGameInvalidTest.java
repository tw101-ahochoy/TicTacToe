package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

import static org.mockito.Mockito.*;

public class TicTacToeGameInvalidTest {
    private TicTacToeGame game;
    @Mock private Board board;
    @Mock private PrintStream printer;
    @Mock private BufferedReader reader;

    @Before
    public void setup(){
        MockitoAnnotations.initMocks(this);
        game = new TicTacToeGame(board, printer, reader, true);
    }

    @Test
    public void shouldDisplayErrorMessageWhenUserHasProvidedNonNumericInput() throws IOException {
        when(reader.readLine()).thenReturn("Apple").thenReturn("Quit");
        game.startGame();
        verify(printer, atLeastOnce()).println("That's not a legal play.");
    }

}
