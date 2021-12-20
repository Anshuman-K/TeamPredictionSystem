package com.api.repository;

import com.api.entity.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Integer> {
}
