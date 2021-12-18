package com.api.controller;

import com.api.entity.Season;
import com.api.service.SeasonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/testing")
public class SeasonController {
    @Autowired
    SeasonService seasonService;

    @GetMapping("/seasons")
    public List<Season> getAllSeasons(){
        return seasonService.getAllService();
    }

    @GetMapping("/seasons/{seasonId}")
    public Season getSeasonById(@PathVariable("seasonId") int seasonId){
        return seasonService.getSeasonById(seasonId);
    }

    @PostMapping("/seasons/league/{leagueId}")
    public String createSeason(@PathVariable("leagueId") int leagueId, @RequestBody Season season){
        return seasonService.createSeason(leagueId, season);
    }
}
