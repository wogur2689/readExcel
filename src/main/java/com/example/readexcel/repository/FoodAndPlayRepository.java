package com.example.readexcel.repository;

import com.example.readexcel.entity.FoodAndPlay;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodAndPlayRepository extends JpaRepository<FoodAndPlay, Long> {
}
