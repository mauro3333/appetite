package com.appetite.appetite.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.appetite.appetite.entity.Orderx;


public interface iOrderRepository extends JpaRepository<Orderx, Long>{
    

    @Override
    public List<Orderx> findAll();


    public Orderx findByorderxId(Long orderxId);

    public Orderx findFirstByOrderByOrderxIdDesc();

    public List<Orderx> findByStatus(String status);

    // @Modifying
    // @Query("UPDATE Orderx x SET x.employeeId = ?1 WHERE x.orderxId = ?2")
    // public void updateEmployeeOrderx(Long employeeId, Long orderxId);

    // @Query("SELECT t FROM Orderx t ORDER BY t.orderxId DESC LIMIT 1") 
    // public List<Orderx> lastOrderXId();
}