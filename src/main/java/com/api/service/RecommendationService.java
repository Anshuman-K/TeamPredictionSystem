package com.api.service;

import com.api.entity.RecommendationData;
import com.api.repository.RecommendationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecommendationService {
    @Autowired
    RecommendationRepository recommendationRepository;


    public String uploadData(RecommendationData data) {
        try {
            recommendationRepository.save(data);
            return "Upload Data Successful";
        }catch (Exception e){
            return "Upload Data Failed";
        }
    }

    public String uploadDataList(List<RecommendationData> data) {
        try {
            recommendationRepository.saveAll(data);
            return "Upload Data Successful";
        }catch (Exception e){
            return "Upload Data Failed";
        }
    }
}
