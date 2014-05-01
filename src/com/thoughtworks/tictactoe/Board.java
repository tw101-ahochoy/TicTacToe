package com.thoughtworks.tictactoe;

import java.io.PrintStream;
import java.util.List;

public class Board {
    private List<String> places;
    private PrintStream printer;

    public Board(List<String> places, PrintStream printer){
        this.places = places;
        this.printer = printer;
    }

    public void displayBoard(){
        StringBuffer board = new StringBuffer();
        int idx = 1;

        board.append("\n");

        for (String place : places) {
            board.append(BoardBuilder.assemble(place, idx));
            idx++;
        }

        printer.println(board.toString());
    }

    public void updateBoard(int place, String player) {
        places.set(place - 1, player);
    }

    public boolean checkMoveLegality(String desiredMove){

        try {
            int move = Integer.parseInt(desiredMove);
            move--;
            places.get(move);
        } catch (NumberFormatException e){
            return false;
        } catch (IndexOutOfBoundsException e){
            return false;
        }

        return true;
    }
}
