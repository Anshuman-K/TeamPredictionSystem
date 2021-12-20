package com.api.service;

import com.api.entity.Player;
import com.api.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PlayerService {
    @Autowired
    PlayerRepository playerRepository;

    public String addPlayer(List<Player> listOfPlayers){
        try{
            playerRepository.saveAll(listOfPlayers);
            return "Successfully added!";
        }
        catch (Exception e){
            return "Something went wrong.";
        }
    }
}
