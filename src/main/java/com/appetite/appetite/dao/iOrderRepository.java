package com.appetite.appetite.dao;


import java.util.List;

//import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.appetite.appetite.entity.Order;


public interface iOrderRepository extends CrudRepository<Order, Long>{ //JpaRepository
    

    @Override
    public List<Order> findAll();

}