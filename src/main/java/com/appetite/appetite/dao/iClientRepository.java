package com.appetite.appetite.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appetite.appetite.entity.Client;


public interface iClientRepository extends JpaRepository<Client, Long> {

    @Override
    // We overide this function because we want to return Project type instead of
    // generic type
    public List<Client> findAll();

    public Client findByclientId(Long clienId);


}
