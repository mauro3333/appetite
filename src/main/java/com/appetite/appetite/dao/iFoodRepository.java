package com.appetite.appetite.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appetite.appetite.entity.Food;


public interface iFoodRepository extends JpaRepository<Food, Long> {

    @Override
    public List<Food> findAll();

}