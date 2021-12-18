package com.api.repository;

import com.api.entity.RecommendationData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecommendationRepository extends JpaRepository<RecommendationData, Integer> {
}
