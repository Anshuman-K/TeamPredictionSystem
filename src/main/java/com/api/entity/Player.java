package com.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int playerId;
    private String playerName;
    private String countryOrigin;
    private String profile;
    private int value;
    private int weight;

    @ManyToMany(mappedBy = "players")
    //@JsonBackReference
    @JsonIgnore
    private List<Team> teams = new ArrayList<>();

    public Player(){}

    public Player(String playerName, String countryOrigin, String profile, int value, int weight) {
        this.playerName = playerName;
        this.countryOrigin = countryOrigin;
        this.profile = profile;
        this.value = value;
        this.weight = weight;
    }

    public void setPlayerId(int playerId) {
        this.playerId = playerId;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public void setCountryOrigin(String countryOrigin) {
        this.countryOrigin = countryOrigin;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }
    public void addTeam(Team team) {
        this.teams.add(team);
    }
    public void addTeamList(List<Team> teamList) {
        this.teams = teamList;
    }
    public void removeTeam(Team team){
        this.teams.remove(team);
    }


	public List<Team> getTeams() {
		return teams;
	}

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Player{" +
                "playerId=" + playerId +
                ", playerName='" + playerName + '\'' +
                ", countryOrigin='" + countryOrigin + '\'' +
                ", profile='" + profile + '\'' +
                ", value=" + value +
                ", weight=" + weight +
                '}';
    }

    public int getPlayerId() {
		return playerId;
	}

	public String getPlayerName() {
		return playerName;
	}

	public String getCountryOrigin() {
		return countryOrigin;
	}

	public String getProfile() {
		return profile;
	}
    
}
