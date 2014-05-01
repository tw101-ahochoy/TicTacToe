package com.thoughtworks.tictactoe;

/**
 * Created by ahochoy on 5/1/14.
 */
 public class PlayerDetails {
    public static String icon(int moveCounter){
        return (moveCounter % 2 == 0) ? "O" : "X";
    }

    public static String id(int moveCounter){
        return (moveCounter % 2 == 0) ? "2" : "1";
    }
}
