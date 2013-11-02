package com.thoughtworks.ns.practice;

public class UglyTennisGame implements TennisGame {
    public int P1point = 0;
    public int P2point = 0;

    public String P1res = "";
    public String P2res = "";
    private String player1Name;
    private String player2Name;

    public UglyTennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    public String getScore(){
        String score = "";
        if (P1point == P2point && P1point < 3)
        {
            if (P1point==0)
                score = "Love";
            if (P1point==1)
                score = "Fifteen";
            if (P1point==2)
                score = "Thirty";
            score += "-All";
            
        }
        if (P1point==P2point && P1point>=3) {
            score = "Deuce";
            
        }

        if (P1point > 0 && P2point==0)
        {
            if (P1point==1)
                P1res = "Fifteen";
            if (P1point==2)
                P1res = "Thirty";
            if (P1point==3)
                P1res = "Forty";

            P2res = "Love";
            score = P1res + "-" + P2res;
            
        }
        if (P2point > 0 && P1point==0)
        {
            if (P2point==1)
                P2res = "Fifteen";
            if (P2point==2)
                P2res = "Thirty";
            if (P2point==3)
                P2res = "Forty";

            P1res = "Love";
            score = P1res + "-" + P2res;
            
        }

        if (P1point>P2point && P1point < 4)
        {
            if (P1point==2)
                P1res="Thirty";
            if (P1point==3)
                P1res="Forty";
            if (P2point==1)
                P2res="Fifteen";
            if (P2point==2)
                P2res="Thirty";
            score = P1res + "-" + P2res;
            
        }
        if (P2point>P1point && P2point < 4)
        {
            if (P2point==2)
                P2res="Thirty";
            if (P2point==3)
                P2res="Forty";
            if (P1point==1)
                P1res="Fifteen";
            if (P1point==2)
                P1res="Thirty";
            score = P1res + "-" + P2res;
            
        }

        if (P1point > P2point && P2point >= 3)
        {
            score = "Advantage " + this.player1Name;
            
        }

        if (P2point > P1point && P1point >= 3)
        {
            score = "Advantage " + this.player2Name;
            
        }

        if (P1point>=4 && P2point>=0 && (P1point-P2point)>=2)
        {
            score = "Win for " + this.player1Name;
            
        }
        if (P2point>=4 && P1point>=0 && (P2point-P1point)>=2)
        {
            score = "Win for " + this.player2Name;
            
        }

        return score;
    }

    public void SetP1Score(int number){

//        for (int i = 0; i < number; i++)
//        {
//            P1Score();
//        }
        P1point = number;

    }

    public void SetP2Score(int number){

//        for (int i = 0; i < number; i++)
//        {
//            P2Score();
//        }
        P2point = number;

    }

    public void P1Score(){
        P1point++;
    }

    public void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player == this.player1Name)
            P1Score();
        else
            P2Score();
    }
}
