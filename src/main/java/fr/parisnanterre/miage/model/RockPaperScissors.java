package fr.parisnanterre.miage.model;

public class RockPaperScissors
{
    RockPaperScissors(){}

    Result play  (Play p1, Play p2)
    {
        if((p1 == Play.PAPER && p2== Play.PAPER) || (p1 == Play.ROCK && p2== Play.ROCK) || (p1 == Play.SCISSORS && p2== Play.SCISSORS))
        {
            return Result.TIE;
        }
         else if((p1 == Play.ROCK && p2== Play.SCISSORS) || (p1 == Play.PAPER && p2== Play.ROCK) || (p1 == Play.SCISSORS && p2== Play.PAPER))
        {
            return  Result.WIN;
        }
        else
        {
            return Result.LOST;
        }

    }

    Result play2 (Play p1, Play p2)
    {
        return Result.LOST;
    }
}

