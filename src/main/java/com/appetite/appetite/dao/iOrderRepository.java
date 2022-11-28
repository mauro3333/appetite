package com.appetite.appetite.dao;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

import com.appetite.appetite.entity.Orderx;


public interface iOrderRepository extends JpaRepository<Orderx, Long>{
    

    @Override
    public List<Orderx> findAll();

        public Orderx findFirstByOrderByOrderxIdDesc();

    // @Query("SELECT t FROM Orderx t ORDER BY t.orderxId DESC LIMIT 1") 
    // public List<Orderx> lastOrderXId();
}