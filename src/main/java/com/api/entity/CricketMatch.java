package com.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
public class CricketMatch {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cricketMatchId;

    @ManyToOne
    @JsonBackReference
    private Season season;

    private String venue;
    private Date date;
    private String location;

    @ManyToMany
    @JsonManagedReference
    @JoinTable(name = "Team_CricketMatch",joinColumns = @JoinColumn(name = "cricketMatch_Id"), inverseJoinColumns = @JoinColumn(name = "team_Id"))
    private List<Team> teams = new ArrayList<>();



	public int getCricketMatchId() {
		return cricketMatchId;
	}

	public void setCricketMatchId(int cricketMatchId) {
		this.cricketMatchId = cricketMatchId;
	}

	public Season getSeason() {
		return season;
	}

	public void setSeason(Season season) {
		this.season = season;
	}

	public String getVenue() {
		return venue;
	}

	public void setVenue(String venue) {
		this.venue = venue;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public List<Team> getTeams() {
		return teams;
	}

	public CricketMatch(Season season, String venue, Date date, String location) {
		super();
		this.season = season;
		this.venue = venue;
		this.date = date;
		this.location = location;
	}

	public CricketMatch() {

	}
    

    public void addTeams(Team teams) {
        this.teams.add(teams);
    }
    public void removeTeams(Team team){
        this.teams.remove(team);
    }

}
