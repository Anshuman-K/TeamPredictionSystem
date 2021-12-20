package com.api.controller;


import com.api.entity.Ipldata;
import com.api.entity.Player;
import com.api.service.PlayerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlayerController {

    @Autowired
    PlayerService playerService;

    @PostMapping("/addplayer")
    public String addPlayer(@RequestBody List<Player> listOfPlayers){
        String response = playerService.addPlayer(listOfPlayers);
        return  response;
    }

}
