package com.thoughtworks.ns.practice;

public class UglyTennisGame implements TennisGame {
    private int P1point = 0;
    private int P2point = 0;

    private String player1Name;
    private String player2Name;

    public UglyTennisGame(String player1Name, String player2Name) {
        this.player1Name = player1Name;
        this.player2Name = player2Name;
    }

    private String tennisTermForScore(int score){
        String tennisTerm;
        switch (score) {
            case 0:{
                tennisTerm = "Love";
                break;
            }
            case 1:{
                tennisTerm = "Fifteen";
                break;
            }
            case 2:{
                tennisTerm = "Thirty";
                break;
            }
            case 3:{
                tennisTerm = "Forty";
                break;
            }
            default:{
                tennisTerm = "";
                break;
            }
        }
        return tennisTerm;
    }

    public String getScore(){
        String score = "";

        int maxScore = Math.max(P1point, P2point);
        int minScore = Math.min(P1point, P2point);
        int scoreDifference = maxScore - minScore;

        String advancedPlayerName = P1point > P2point ? this.player1Name : this.player2Name;

        if (maxScore >= 4 && scoreDifference >= 2) {
            //We have a winner
            score = "Win for " + advancedPlayerName;
        } else if (minScore >= 3) {
            if (scoreDifference == 0) {
                //Deuce
                score = "Deuce";
            } else {
                //Advantage
                score = "Advantage " + advancedPlayerName;
            }
        } else if (scoreDifference == 0) {
            score = tennisTermForScore(maxScore) + "-All";
        } else {
            score = tennisTermForScore(P1point) + "-" + tennisTermForScore(P2point);
        }

        return score;
    }

    private void P1Score(){
        P1point++;
    }

    private void P2Score(){
        P2point++;
    }

    public void wonPoint(String player) {
        if (player.equals(this.player1Name))
            P1Score();
        else
            P2Score();
    }
}
