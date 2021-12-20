package com.api.service;

import com.api.entity.Player;
import com.api.entity.RecommendationData;
import com.api.entity.Team;
import com.api.repository.RecommendationRepository;
import com.api.repository.TeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class RecommendationService {
    @Autowired
    RecommendationRepository recommendationRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TeamRepository teamRepository;


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

    public Optional<RecommendationData> getPlayerData(Integer id){
        Optional<RecommendationData> recommendationData = recommendationRepository.findById(id);
        return recommendationData;
    }

    public List<Player> recommendPlayers(Integer id1, Integer id2) {

        List<Player> listA = teamRepository.getById(id1).getPlayers();
        List<Player> listB = teamRepository.getById(id2).getPlayers();
        List<Player> allPlayers = new ArrayList<>();
        allPlayers.addAll(listA);
        allPlayers.addAll(listB);

        int W[] = new int[allPlayers.size()];
        int V[] = new int[allPlayers.size()];

        for(int i=0;i<allPlayers.size();i++){
            W[i] = allPlayers.get(i).getWeight();
            V[i] = allPlayers.get(i).getValue();
        }
        int n = allPlayers.size();
        int M = 100;

        int B[][] = new int[n + 1][M + 1];

        for (int i=0; i<=n; i++)
            for (int j=0; j<=M; j++) {
                B[i][j] = 0;
            }

        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= M; j++) {
                B[i][j] = B[i - 1][j];

                if ((j >= W[i-1]) && (B[i][j] < B[i - 1][j - W[i - 1]] + V[i - 1])) {
                    B[i][j] = B[i - 1][j - W[i - 1]] + V[i - 1];
                }
            }
        }
        List<Player> returningList = new ArrayList<>();
        while (n != 0) {
            if (B[n][M] != B[n - 1][M]) {
                returningList.add(allPlayers.get(n));
                M = M - W[n-1];
            }

            n--;
        }




        return returningList;
    }
}
