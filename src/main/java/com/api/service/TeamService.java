package com.api.service;

import com.api.entity.Player;
import com.api.entity.Team;
import com.api.repository.PlayerRepository;
import com.api.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class TeamService {
    @Autowired
    TeamRepository teamRepository;

    @Autowired
    PlayerRepository playerRepository;

    public String createTeam(List<Team> team) {
        teamRepository.saveAll(team);
        return "Created";
    }

    public List<Team> getAllTeams() {
        return teamRepository.findAll();
    }


    public Team findTeamById(int teamId) {
        Optional<Team> team = teamRepository.findById(teamId);
        if (team.isEmpty()) return null;
        return team.get();
    }

    public String assignPlayers(int teamId, List<Integer> playersId) {
        Optional<Team> team = teamRepository.findById(teamId);
        if (team.isEmpty()) return "Team not found";
        List<Player> allPlayers = new ArrayList<>();
        List<Integer> addedPlayers = new ArrayList<>();
        for(int playerId: playersId){
            Optional<Player> player = playerRepository.findById(playerId);
            if (!player.isEmpty()){
                allPlayers.add(player.get());
                addedPlayers.add(playerId);
            }
        }
        if (allPlayers.size()==0) return "No Players found";
        try{
            team.get().addPlayer(allPlayers);
            return addedPlayers.toString() +" Players allocated to team";
        }catch (Exception e){
            return "Players allocation failed";
        }
    }
}
