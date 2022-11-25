package com.appetite.appetite.dao;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.appetite.appetite.entity.Client;




public interface iCheckRepository extends JpaRepository<Client, Long> {

    //@Override
    //We overide this function because we want to return Project type instead of generic type
    @Query("SELECT x FROM Client x WHERE email = ?1 AND password = ?2") //clientId
    public Client findByEmailAndPassword(String email, String password);
    
}