package com.sandtiger.research;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameTest{

    private Game game;

    @BeforeEach
    public void setup(){
       game = new Game();
    }

    private void rollAllSame(int frames, int pins){
        for (int i = 0; i < frames; i++){
            game.roll(pins);
        }
    }

    private void rollSpare(){
        game.roll(5);
        game.roll(5);
    }

    private void rollStrike(){
        game.roll(10);
    }

    @Test
    public void rollGutterGame(){
        rollAllSame(20, 0);
        assertEquals(0, game.score());
    }

    @Test
    public void rollAllOnes(){
        rollAllSame(20, 1);
        assertEquals(20, game.score());
    }

    @Test
    public void rollSingleSpare(){
        rollSpare();
        game.roll(4);
        rollAllSame(14, 0);
        assertEquals(18, game.score());
    }

    @Test
    public void rollSingleStrike(){
        rollStrike();
        game.roll(4);
        game.roll(5);
        rollAllSame(16, 0);
        assertEquals(28, game.score());
    }

    @Test
    public void rollAllStrikes(){
        rollAllSame(12, 10);
        assertEquals(300, game.score());
    }


}