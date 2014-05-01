package com.thoughtworks.tictactoe;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class BoardBuilderTest {

    @Test
    public void shouldHaveListOfSingleSpaceWhenGeneratingEmptySpacesOfOne() {
        List<String> actualResults = BoardBuilder.generateEmptySpaces(1);
        List<String> expectedResults = new ArrayList<String>();
        expectedResults.add(" ");
        assertEquals(actualResults, expectedResults);
    }

    @Test
    public void shouldContainSpaceRowDividerAndCharacterWhenAssemblingIndexOfThree(){
        String assembled = BoardBuilder.assemble(" ", 3);
        assertThat(assembled, is("   \n-----------\n"));
    }

    @Test
    public void shouldContainSpacesAndCharacterWhenAssemblingIndexOfNine(){
        String assembled = BoardBuilder.assemble(" ", 9);
        assertThat(assembled, is("   \n"));
    }

    @Test
    public void shouldContainSpaceAndBarWhenAssemblingIndexOfTwo(){
        String assembled = BoardBuilder.assemble(" ", 1);
        assertThat(assembled, is("   |"));
    }
}