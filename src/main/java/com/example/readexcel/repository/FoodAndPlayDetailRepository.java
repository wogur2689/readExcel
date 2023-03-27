package com.example.readexcel.repository;

import com.example.readexcel.entity.FoodAndPlayDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodAndPlayDetailRepository extends JpaRepository<FoodAndPlayDetail, Long> {
}
