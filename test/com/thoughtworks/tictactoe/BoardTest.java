package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.io.PrintStream;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;

public class BoardTest {
    @Mock private PrintStream printer;
    private Board board;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
        board = new Board(BoardBuilder.generateEmptySpaces(9), printer);
    }

    @Test
    public void shouldPrintBoardWhenDisplayed(){
        board.displayBoard();
        verify(printer).println("\n   |   |   \n-----------\n   |   |   \n-----------\n   |   |   \n");
    }

    @Test
    public void shouldReturnFalseWhenGivenNonNumber(){
        assertFalse( board.checkMoveLegality("NON NUMBER"));
    }

    @Test
    public void shouldReturnFalseWhenGivenNumberOutOfBounds(){
        assertFalse( board.checkMoveLegality("90"));
    }

    @Test
    public void shouldReturnTrueWhenGivenValidNumber(){
        assertTrue(board.checkMoveLegality("6"));
    }
}