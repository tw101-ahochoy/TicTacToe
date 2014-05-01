package com.thoughtworks.tictactoe;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

public class PlayerDetailsTest {

    @Test
    public void shouldReturnIconXWhenMoveIsOdd() throws Exception {
        assertThat(PlayerDetails.icon(3), is("X"));
    }

    @Test
    public void shouldReturnId2WhenMoveIsEven() throws Exception {
        assertThat(PlayerDetails.id(8), is("2"));
    }
}