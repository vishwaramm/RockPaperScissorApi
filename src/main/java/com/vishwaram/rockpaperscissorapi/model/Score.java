package com.vishwaram.rockpaperscissorapi.model;

public class Score {
    private int wins;
    private int ties;
    private int losses;

    public Score() {
    }

    public Score(int wins, int ties, int losses) {
        this.wins = wins;
        this.ties = ties;
        this.losses = losses;
    }

    public void setWins(int wins) {
        this.wins = wins;
    }

    public void setTies(int ties) {
        this.ties = ties;
    }

    public void setLosses(int losses) {
        this.losses = losses;
    }

    public int getWins() {
        return wins;
    }

    public int getTies() {
        return ties;
    }

    public int getLosses() {
        return losses;
    }
}
