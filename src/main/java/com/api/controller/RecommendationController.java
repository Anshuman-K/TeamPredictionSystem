package com.api.controller;

import com.api.entity.Player;
import com.api.entity.RecommendationData;
import com.api.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/testing")
public class RecommendationController {
    @Autowired
    RecommendationService recommendationService;
    private Object RecommendationData;

//    @PostMapping("/upload")
//    public String uploadData(@RequestBody RecommendationData data){
//        String response = recommendationService.uploadData(data);
//        return  response;
//    }

    @PostMapping("/upload")
    public String uploadData(@RequestBody List<RecommendationData> data){
        String response = recommendationService.uploadDataList(data);
        return  response;
    }

    @GetMapping("/playerData/{id}")
    public RecommendationData getPlayerData(@RequestBody Integer id){
        return (com.api.entity.RecommendationData) (RecommendationData = recommendationService.getPlayerData(id));
    }

    @GetMapping("/suggestion/{id1}/{id2}")
    public List<Player> recommendPlayer(@PathVariable Integer id1, @PathVariable Integer id2){
        return recommendationService.recommendPlayers(id1, id2);
    }
}
