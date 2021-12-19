package com.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamId;
    private String teamName;

    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "Player_Team",joinColumns = @JoinColumn(name = "team_Id"), inverseJoinColumns = @JoinColumn(name = "player_Id"))
    private List<Player> players = new ArrayList<>();

    @ManyToMany(mappedBy = "teams")
    @JsonIgnore
    private List<CricketMatch> cricketMatch = new ArrayList<>();

    public Team(){

    }
    public Team(int teamId, String teamName) {
        this.teamId = teamId;
        this.teamName = teamName;
    }

    public void addPlayer(Player player){
        this.players.add(player);
    }
    public void addPlayer(List<Player> players){
        this.players = players;
    }

    public void removePlayer(Player player){
        this.players.remove(player);
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getTeamId() {
        return teamId;
    }

    public String getTeamName() {
        return teamName;
    }

    public List<Player> getPlayers() {
        return players;
    }

    public List<CricketMatch> getCricketMatch() {
        return cricketMatch;
    }
}
