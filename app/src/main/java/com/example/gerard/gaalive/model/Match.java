package com.example.gerard.gaalive.model;

import android.media.Image;

/**
 * Created by gerard on 19/01/2018.
 */

public class Match {
    String competition;
    String game;
    String homeTeam;
    String awayTeam;
    String score;

    public String getCompetition() {
        return competition;
    }

    public void setCompetition(String competition) {
        this.competition = competition;
    }

    public String getGame() {
        return game;
    }

    public void setGame(String game) {
        this.game = game;
    }

    public String getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(String homeTeam) {
        this.homeTeam = homeTeam;
    }

    public String getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(String awayTeam) {
        this.awayTeam = awayTeam;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public Match(String competition, String game, String homeTeam, String awayTeam, String score) {

        this.competition = competition;
        this.game = game;
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.score = score;
    }

    public Match() {

    }
}