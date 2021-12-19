package com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class RecommendationData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int matchId;
    private int runsScored;
    private int ballsFaced;
    private int runsGiven;
    private int bowled;
    private int wicketsTaken;

    public RecommendationData(){}

    public RecommendationData(int id, String name, int matchId, int runsScored, int ballsFaced, int runsGiven, int bowled, int wicketsTaken) {
        this.id = id;
        this.name = name;
        this.matchId = matchId;
        this.runsScored = runsScored;
        this.ballsFaced = ballsFaced;
        this.runsGiven = runsGiven;
        this.bowled = bowled;
        this.wicketsTaken = wicketsTaken;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMatchId() {
        return matchId;
    }

    public void setMatchId(int matchId) {
        this.matchId = matchId;
    }

    public int getRunsScored() {
        return runsScored;
    }

    public void setRunsScored(int runsScored) {
        this.runsScored = runsScored;
    }

    public int getBallsFaced() {
        return ballsFaced;
    }

    public void setBallsFaced(int ballsFaced) {
        this.ballsFaced = ballsFaced;
    }

    public int getRunsGiven() {
        return runsGiven;
    }

    public void setRunsGiven(int runsGiven) {
        this.runsGiven = runsGiven;
    }

    public int getBowled() {
        return bowled;
    }

    public void setBowled(int bowled) {
        this.bowled = bowled;
    }

    public int getWicketsTaken() {
        return wicketsTaken;
    }

    public void setWicketsTaken(int wicketsTaken) {
        this.wicketsTaken = wicketsTaken;
    }
}
