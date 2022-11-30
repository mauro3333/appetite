package com.appetite.appetite.dao;


import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.appetite.appetite.entity.Employee;


public interface iEmployeeRepository extends JpaRepository<Employee, Long>{

    @Override
    public List<Employee> findAll();
}
