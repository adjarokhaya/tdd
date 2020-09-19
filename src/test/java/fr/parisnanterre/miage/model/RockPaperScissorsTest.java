package fr.parisnanterre.miage.model;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class RockPaperScissorsTest {

    RockPaperScissors rps;
    @BeforeMethod
    public void setUp() {
        rps = new RockPaperScissors();
    }

    @AfterMethod
    public void tearDown() {
        rps = null;
    }

    @Parameters({"ciseaux", "papier"})
    @Test
    void testWinPlay(String p1, String p2)
    {
        Result r = rps.play(Play.valueOf(p1), Play.valueOf(p2));
        assertEquals(r,Result.WIN);
    }

    @Parameters({"ciseaux", "ciseaux"})
    @Test
    void testTiePlay(String p1, String p2)
    {
        Result r = rps.play(Play.valueOf(p1), Play.valueOf(p2));
        assertEquals(r,Result.TIE);
    }

    @Parameters({"papier", "ciseaux"})
    @Test
    void testLostPlay(String p1, String p2)
    {
        Result r = rps.play(Play.valueOf(p1), Play.valueOf(p2));
        assertEquals(r,Result.LOST);
    }

}