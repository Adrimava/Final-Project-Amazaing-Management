package com.ironhack.finalproject.amazaingmanagement.repository;

import com.ironhack.finalproject.amazaingmanagement.model.Player;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlayerRepository extends JpaRepository<Player, Long> {
}
