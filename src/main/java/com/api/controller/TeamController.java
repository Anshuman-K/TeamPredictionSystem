package com.api.controller;

import com.api.entity.Team;
import com.api.service.TeamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/testing")
public class TeamController {
    @Autowired
    TeamService teamService;

    @PostMapping("/createteam")
    public String createteam(@RequestBody List<Team> team){
        return teamService.createTeam(team);
    }

    @GetMapping("/allteams")
    public List<Team> getAllTeams(){
        return teamService.getAllTeams();
    }

    @GetMapping("/team/{teamid}")
    public Team getTeam(@PathVariable("teamid") int teamId){
        return teamService.findTeamById(teamId);
    }

    @PostMapping("/assignPlayers/team/{teamid}")
    public String assignPlayers(@PathVariable("teamid") int teamId, @RequestBody List<Integer> playersId){
        return teamService.assignPlayers(teamId, playersId);
    }
}
