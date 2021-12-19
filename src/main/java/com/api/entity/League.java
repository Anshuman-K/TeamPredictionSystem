package com.api.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.Fetch;

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
    public League(){}
    public League(int leagueId, String leagueName, boolean isDomestic) {
        this.leagueId = leagueId;
        this.leagueName = leagueName;
        this.isDomestic = isDomestic;
    }

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

    public void setDomestic(boolean domestic) {
        isDomestic = domestic;
    }
}
