package com.api.service;

import com.api.entity.Format;
import com.api.entity.League;
import com.api.repository.FormatRepository;
import com.api.repository.LeagueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LeagueService {
    @Autowired
    LeagueRepository leagueRepository;

    @Autowired
    FormatRepository formatRepository;

    public List<League> getAllLeagues() {
        return leagueRepository.findAll();
    }

    public League getLeagueById(int leagueId) {
        Optional<League> league = leagueRepository.findById(leagueId);
        if (league.isEmpty()) return null;
        return league.get();
    }

    public String createLeague(int formatId, League league) {
        Optional<Format> format = formatRepository.findById(formatId);
        if (format.isEmpty()) return "Format not found";
        league.setFormat(format.get());
        leagueRepository.save(league);
        return "League Created";
    }

    public String deleteLeague(int leagueId) {
        Optional<League> league = leagueRepository.findById(leagueId);
        if (league.isEmpty()) return "League not found";
        try {
            leagueRepository.delete(league.get());
            return "League delete successfully";
        }catch (Exception e){
            return "League delete failed";
        }
    }
}
