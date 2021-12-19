package com.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;

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

    @ManyToMany(mappedBy = "players")
    @JsonBackReference
    private List<Team> teams = new ArrayList<>();

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

	public void setTeams(List<Team> teams) {
		this.teams = teams;
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

	public Player(int playerId, String playerName, String countryOrigin, String profile, List<Team> teams) {
		super();
		this.playerId = playerId;
		this.playerName = playerName;
		this.countryOrigin = countryOrigin;
		this.profile = profile;
		this.teams = teams;
	}
    
    public Player() {
    	
    }
}
