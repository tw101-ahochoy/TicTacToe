package com.thoughtworks.tictactoe;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Board board = new Board( BoardBuilder.generateEmptySpaces(9), System.out);
        TicTacToeGame game = new TicTacToeGame(board, System.out, reader, true);

        game.startGame();
    }
}
