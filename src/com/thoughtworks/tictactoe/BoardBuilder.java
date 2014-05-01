package com.thoughtworks.tictactoe;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by ahochoy on 5/1/14.
 */
public class BoardBuilder {
    public static List<String> generateEmptySpaces(int size) {
        List<String> emptyList = new ArrayList<String>();
        for (int i = 0; i < size; i++){
            emptyList.add(" ");
        }
        return emptyList;
    }

    public static String assemble(String place, int idx) {
        String assemblage;

        if( idx == 3 || idx == 6 ){
            assemblage = " " + place + " \n-----------\n";
        } else if ( idx == 9 ){
            assemblage = " " + place + " \n";
        } else {
            assemblage = " " + place + " |";
        }
        return assemblage;
    }
}
