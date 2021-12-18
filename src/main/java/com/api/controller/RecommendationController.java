package com.api.controller;

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
}
