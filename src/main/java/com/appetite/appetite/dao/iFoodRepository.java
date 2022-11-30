package com.appetite.appetite.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.appetite.appetite.entity.Food;

public interface iFoodRepository extends JpaRepository<Food, Long> {

    @Override
    public List<Food> findAll();

    @Query("SELECT x FROM Food x WHERE foodId = ?1")
    public Food findByFoodId(Long id);

}