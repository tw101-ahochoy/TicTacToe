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

public class TicTacToeGameTest {
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
    public void shouldDisplayBoardWhenGameStart() throws IOException {
        when(reader.readLine()).thenReturn("1").thenReturn("Quit");
        game.startGame();
        verify(board, atLeastOnce()).displayBoard();
    }

    @Test
    public void shouldPromptUserWhenBoardDisplayed() throws IOException {
        when(reader.readLine()).thenReturn("1").thenReturn("Quit");
        InOrder inOrder = inOrder(board,printer,reader);
        game.startGame();
        inOrder.verify(board).displayBoard();
        inOrder.verify(printer).print("It's your turn Player 1. Select a spot to play by entering a number 1 - 9: ");
        inOrder.verify(reader).readLine();
    }

    @Test
    public void shouldUpdateBoardWhenUserHasProvidedValidInput() throws IOException {
        when(reader.readLine()).thenReturn("1").thenReturn("Quit");
        when(board.checkMoveLegality("1")).thenReturn(true);
        game.startGame();
        verify(board, atLeastOnce()).updateBoard(1, "X");
    }

    @Test
    public void shouldDisplayErrorMessageWhenUserHasProvidedNonNumericInput() throws IOException {
        when(reader.readLine()).thenReturn("Apple").thenReturn("Quit");
        game.startGame();
        verify(printer, atLeastOnce()).println("That's not a legal play.");
    }

    @Test
    public void shouldStopGameWhenEitherPlayQuits() throws IOException {
        when(reader.readLine()).thenReturn("1").thenReturn("Quit");
        InOrder inOrder = inOrder(board,printer,reader);
        game.startGame();
        inOrder.verify(board, times(1)).displayBoard();
        inOrder.verify(printer).print("Thanks for playing!");
    }
}
