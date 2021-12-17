package com.api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int teamId;
    private String teamName;

    @ManyToMany
    @JsonManagedReference
    @JoinTable(name = "Player_Team",joinColumns = @JoinColumn(name = "team_Id"), inverseJoinColumns = @JoinColumn(name = "player_Id"))
    private List<Player> players = new ArrayList<>();

    @ManyToMany(mappedBy = "teams")
    @JsonBackReference
    private List<CricketMatch> cricketMatch = new ArrayList<>();

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
}
