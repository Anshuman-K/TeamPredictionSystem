package com.api.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ipldata {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int matchId;
    private int inning;
    private int over_num;
    private int ball;
    private String batsman;
    private String non_striker;
    private String bowler;
    private int batsman_runs;
    private int extra_runs;
    private int total_runs;
    private int non_boundary;
    private int is_wicket;
    private String dismissal_kind;
    private String player_dismissed;
    private String fielder;
    private String extras_type;
    private String batting_team;
    private String bowling_team;

        
	public int getId() {
		return id;
	}
	public int getMatchId() {
		return matchId;
	}
	public void setMatchId(int matchId) {
		this.matchId = matchId;
	}
	public int getInning() {
		return inning;
	}
	public void setInning(int inning) {
		this.inning = inning;
	}
	public int getOver_num() {
		return over_num;
	}
	public void setOver_num(int over_num) {
		this.over_num = over_num;
	}
	public int getBall() {
		return ball;
	}
	public void setBall(int ball) {
		this.ball = ball;
	}
	public String getBatsman() {
		return batsman;
	}
	public void setBatsman(String batsman) {
		this.batsman = batsman;
	}
	public String getNon_striker() {
		return non_striker;
	}
	public void setNon_striker(String non_striker) {
		this.non_striker = non_striker;
	}
	public String getBowler() {
		return bowler;
	}
	public void setBowler(String bowler) {
		this.bowler = bowler;
	}
	public int getBatsman_runs() {
		return batsman_runs;
	}
	public void setBatsman_runs(int batsman_runs) {
		this.batsman_runs = batsman_runs;
	}
	public int getExtra_runs() {
		return extra_runs;
	}
	public void setExtra_runs(int extra_runs) {
		this.extra_runs = extra_runs;
	}
	public int getTotal_runs() {
		return total_runs;
	}
	public void setTotal_runs(int total_runs) {
		this.total_runs = total_runs;
	}
	public int getNon_boundary() {
		return non_boundary;
	}
	public void setNon_boundary(int non_boundary) {
		this.non_boundary = non_boundary;
	}
	public int getIs_wicket() {
		return is_wicket;
	}
	public void setIs_wicket(int is_wicket) {
		this.is_wicket = is_wicket;
	}
	public String getDismissal_kind() {
		return dismissal_kind;
	}
	public void setDismissal_kind(String dismissal_kind) {
		this.dismissal_kind = dismissal_kind;
	}
	public String getPlayer_dismissed() {
		return player_dismissed;
	}
	public void setPlayer_dismissed(String player_dismissed) {
		this.player_dismissed = player_dismissed;
	}
	public String getFielder() {
		return fielder;
	}
	public void setFielder(String fielder) {
		this.fielder = fielder;
	}
	public String getExtras_type() {
		return extras_type;
	}
	public void setExtras_type(String extras_type) {
		this.extras_type = extras_type;
	}
	public String getBatting_team() {
		return batting_team;
	}
	public void setBatting_team(String batting_team) {
		this.batting_team = batting_team;
	}
	public String getBowling_team() {
		return bowling_team;
	}
	public void setBowling_team(String bowling_team) {
		this.bowling_team = bowling_team;
	}
	public Ipldata(int id, int matchId, int inning, int over_num, int ball, String batsman, String non_striker,
			String bowler, int batsman_runs, int extra_runs, int total_runs, int non_boundary, int is_wicket,
			String dismissal_kind, String player_dismissed, String fielder, String extras_type, String batting_team,
			String bowling_team) {
		super();
		this.id = id;
		this.matchId = matchId;
		this.inning = inning;
		this.over_num = over_num;
		this.ball = ball;
		this.batsman = batsman;
		this.non_striker = non_striker;
		this.bowler = bowler;
		this.batsman_runs = batsman_runs;
		this.extra_runs = extra_runs;
		this.total_runs = total_runs;
		this.non_boundary = non_boundary;
		this.is_wicket = is_wicket;
		this.dismissal_kind = dismissal_kind;
		this.player_dismissed = player_dismissed;
		this.fielder = fielder;
		this.extras_type = extras_type;
		this.batting_team = batting_team;
		this.bowling_team = bowling_team;
	}
	
	public Ipldata() {
		
	}
	
	
	@Override
	public String toString() {
		return "Ipldata [id=" + id + ", matchId=" + matchId + ", inning=" + inning + ", over_num=" + over_num
				+ ", ball=" + ball + ", batsman=" + batsman + ", non_striker=" + non_striker + ", bowler=" + bowler
				+ ", batsman_runs=" + batsman_runs + ", extra_runs=" + extra_runs + ", total_runs=" + total_runs
				+ ", non_boundary=" + non_boundary + ", is_wicket=" + is_wicket + ", dismissal_kind=" + dismissal_kind
				+ ", player_dismissed=" + player_dismissed + ", fielder=" + fielder + ", extras_type=" + extras_type
				+ ", batting_team=" + batting_team + ", bowling_team=" + bowling_team + "]";
	}
    

}
