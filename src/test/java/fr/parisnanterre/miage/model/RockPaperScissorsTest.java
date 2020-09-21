package fr.parisnanterre.miage.model;

import org.testng.annotations.*;

import static org.testng.Assert.*;
import org.testng.annotations.DataProvider;

public class RockPaperScissorsTest {

    RockPaperScissors rps;
    Player p1, p2 ;
    int mouvementsP1[] ;
    int mouvementsP2[];
    @BeforeMethod
    public void setUp() {
        rps = new RockPaperScissors();
        mouvementsP1  = new int[]{0,1,2,0,1,2,0,1,2,0};
        mouvementsP2  = new int[]{1,2,1,1,2,1,1,2,1,1};
        p1 = new Player("rokhaya", mouvementsP1);
        p2 = new Player("adja", mouvementsP2);

    }

    @AfterMethod
    public void tearDown()
    {
        rps = null;
        mouvementsP1 = null;
        mouvementsP2 = null;
        p1 = null;
        p2 = null;
    }
    @DataProvider(name = "Players")
    public Object[] createPlayers() {
        return new Object[]{p1, p2};
    }
    @Test (dataProvider ="Players")
    void testWinPlay2(Play p1, Play p2)
    {
        Result r = rps.play(p1, p2);
        assertEquals(r,Result.WIN);
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

    @DataProvider(name = "winData")
    public Object[][] createWinData() {
        return new Object[][]{{Play.SCISSORS, Play.PAPER}, {Play.PAPER, Play.ROCK}, {Play.ROCK, Play.SCISSORS} };
    }
    @Test (dataProvider ="tieData")
    void testWinPlay(Play p1, Play p2)
    {
        Result r = rps.play(p1, p2);
        assertEquals(r,Result.WIN);
    }

    @DataProvider(name = "lostData")
    public Object[][] createLostData() {
        return new Object[][]{{Play.PAPER, Play.SCISSORS}, {Play.ROCK, Play.PAPER}, {Play.SCISSORS, Play.ROCK} };
    }
    @Test (dataProvider ="winData")
    void testLostPlay(Play p1, Play p2)
    {
        Result r = rps.play(p1, p2);
        assertEquals(r,Result.LOST);
    }

    @DataProvider(name = "tieData")
    public Object[][] createTieData() {
        return new Object[][]{{Play.SCISSORS, Play.SCISSORS}, {Play.PAPER, Play.PAPER}, {Play.ROCK, Play.ROCK} };
    }
    @Test (dataProvider ="lostData")
    void testTiePlay(Play p1, Play p2)
    {
        Result r = rps.play(p1, p2);
        assertEquals(r,Result.TIE);
    }

}