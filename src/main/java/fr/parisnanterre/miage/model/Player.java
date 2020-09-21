package fr.parisnanterre.miage.model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class Player
{
    private  String nom;
    private int score;
    private List<Play> mouvements ;
    public  static int nMouvements = 10;

    public Player(String nom, List<Play>mouvements)
    {
        this.nom = nom;
        this.mouvements = mouvements;
    }

    public static int getnMouvements() {
        return nMouvements;
    }

    private static Play generateFor(int nb)
    {
        switch(nb) {
            case 0: return Play.ROCK;
            case 1: return Play.PAPER;
            default: return Play.SCISSORS;
        }
    }
    private static Play generatePlay()
    {
        int x = (int) (Math.random() * 3);
        return generateFor(x);
    }

    public static List<Play> generatePlays(int taille)
    {
        List<Play> rtr = new ArrayList<Play>(taille);
        for(int i = 0; i<taille; i++) {
            rtr.add(generatePlay());
        }
        return rtr;
    }

    public Player(String nom)
    {
        this.nom = nom;
        this.mouvements=generatePlays(getnMouvements());
    }

    public String getNom(){ return this.nom; }

    public int getScore(){ return this.score; }


    public void SetScore(int score){ this.score = score; }

    public Play GetNextMove()
    {
        Iterator iter = mouvements.iterator();
        while (iter.hasNext()){
            return (Play) iter.next();
        }
        return null;

    }



}
