package com.api.controller;

import com.api.entity.League;
import com.api.service.LeagueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/testing")
public class LeagueController {
    @Autowired
    LeagueService leagueService;

    @GetMapping("/leagues")
    public List<League> getAllLeagues(){
        return leagueService.getAllLeagues();
    }
    @GetMapping("/leagues/{leagueId}")
    public League getLeagueById(@PathVariable("leagueId") int leagueId){
        return leagueService.getLeagueById(leagueId);
    }

    @PostMapping("/leagues/format/{formatId}")
    public String createLeague(@PathVariable("formatId") int formatId,@RequestBody League league){
        return leagueService.createLeague(formatId,league);
    }

    @DeleteMapping("/leagues/{leagueId}")
    public String deleteLeagueById(@PathVariable("leagueId") int leagueId){
        return leagueService.deleteLeague(leagueId);
    }

}
