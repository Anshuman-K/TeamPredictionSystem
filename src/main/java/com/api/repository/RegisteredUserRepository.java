package com.api.repository;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import com.api.entity.RegisteredUserEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;


@Transactional(readOnly = true)
@Repository
public interface RegisteredUserRepository extends JpaRepository<RegisteredUserEntity, String> {
  public Optional<RegisteredUserEntity> findByEmail(String email);
  
  @Transactional
  @Modifying
  @Query("UPDATE RegisteredUserEntity a " +
          "SET a.enabled = TRUE WHERE a.email = ?1")
  int enableAppUser(String email);
}
