package com.api.entity;

import javax.persistence.*;

@Entity
@Table(name="League")

public class League {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int leagueId;
    private String leagueName;

    @OneToOne
    @JoinColumn(name = "formatId")
    private Format format;
    private boolean isDomestic;
    
    
	public int getLeagueId() {
		return leagueId;
	}
	public void setLeagueId(int leagueId) {
		this.leagueId = leagueId;
	}
	public String getLeagueName() {
		return leagueName;
	}
	public void setLeagueName(String leagueName) {
		this.leagueName = leagueName;
	}
	public Format getFormat() {
		return format;
	}
	public void setFormat(Format format) {
		this.format = format;
	}
	public boolean isDomestic() {
		return isDomestic;
	}
	public void setDomestic(boolean isDomestic) {
		this.isDomestic = isDomestic;
	}
	
	
	public League(int leagueId, String leagueName, Format format, boolean isDomestic) {
		super();
		this.leagueId = leagueId;
		this.leagueName = leagueName;
		this.format = format;
		this.isDomestic = isDomestic;
	}
	
	public League() {
		
	}
	@Override
	public String toString() {
		return "League [leagueId=" + leagueId + ", leagueName=" + leagueName + ", format=" + format + ", isDomestic="
				+ isDomestic + "]";
	}
}
