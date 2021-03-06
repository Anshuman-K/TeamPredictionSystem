package com.api.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity

public class Season {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int seasonId;

    @OneToOne
    @JoinColumn(name = "leagueId")
    private League league;

    private Date startDate;
    private Date endDate;

    @OneToMany(mappedBy = "season", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<CricketMatch> cricketMatchList = new ArrayList<>();


	public int getSeasonId() {
		return seasonId;
	}

	public void setSeasonId(int seasonId) {
		this.seasonId = seasonId;
	}

	public League getLeague() {
		return league;
	}

	public void setLeague(League league) {
		this.league = league;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<CricketMatch> getCricketMatchList() {
		return cricketMatchList;
	}
	
	@Override
	public String toString() {
		return "Season [seasonId=" + seasonId + ", league=" + league + ", startDate=" + startDate + ", endDate="
				+ endDate + ", cricketMatchList=" + cricketMatchList + "]";
	}

	public Season() {
		
	}

	public Season(League league, Date startDate, Date endDate, List<CricketMatch> cricketMatchList) {
		super();
		this.league = league;
		this.startDate = startDate;
		this.endDate = endDate;
		this.cricketMatchList = cricketMatchList;
	}

    public void addCricketMatchList(CricketMatch cricketMatchList) {
        this.cricketMatchList.add(cricketMatchList);
    }
    public void removeCricketMatchList(CricketMatch cricketMatchList) {
        this.cricketMatchList.remove(cricketMatchList);
    }
}
