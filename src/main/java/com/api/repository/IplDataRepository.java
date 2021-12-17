package com.api.repository;

import com.api.entity.Ipldata;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IplDataRepository extends JpaRepository<Ipldata, Integer> {
}
