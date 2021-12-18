package com.api.service;

import com.api.entity.League;
import com.api.entity.Season;
import com.api.repository.LeagueRepository;
import com.api.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SeasonService {
    @Autowired
    SeasonRepository seasonRepository;

    @Autowired
    LeagueRepository leagueRepository;

    public List<Season> getAllService() {
        return seasonRepository.findAll();
    }

    public Season getSeasonById(int seasonId) {
        Season season = seasonRepository.getById(seasonId);
        return season;
    }

    public String createSeason(int leagueId, Season season) {
        Optional<League> league = leagueRepository.findById(leagueId);
        if (league.isEmpty()) return "League not found";
        try {
            season.setLeague(league.get());
            return "Season Created Successful";
        }catch (Exception e){
            return "Season creation failed";
        }


    }
}
