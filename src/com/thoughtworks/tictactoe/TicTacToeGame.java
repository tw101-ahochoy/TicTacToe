package com.thoughtworks.tictactoe;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;

public class TicTacToeGame {
    private Board board;
    private PrintStream printer;
    private BufferedReader reader;
    private boolean letsPlay;

    public TicTacToeGame(Board board, PrintStream printer, BufferedReader reader, boolean letsPlay) {

        this.board = board;
        this.printer = printer;
        this.reader = reader;
        this.letsPlay = letsPlay;
    }

    public void startGame() throws IOException {

        int count = 1;
        while(letsPlay) {
            board.displayBoard();
            printPlayerPrompt(count);

            String userInput = reader.readLine();

            if ( board.checkMoveLegality( userInput )){
                board.updateBoard(Integer.parseInt( userInput ), PlayerDetails.icon(count));
            } else {
                if (userInput.equalsIgnoreCase("quit")) {
                    printer.print("Thanks for playing!");
                    letsPlay = false;
                } else {
                    printer.println("That's not a legal play.");
                }
            }

            count ++;
        }
    }

    private void printPlayerPrompt(int moveCounter ){
        printer.print("It's your turn Player " + PlayerDetails.id(moveCounter)
            + ". Select a spot to play by entering a number 1 - 9: ");
    }
}
