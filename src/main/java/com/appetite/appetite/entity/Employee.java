package com.appetite.appetite.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
    @Id // Makes the primary key
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long employeeId;

	private String firstName;
	private String lastName;
	private Long phone;



    public Employee() {
    }

    public Employee(String firstName, String lastName, Long phone) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
    }

    
    public Long getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Long employeeId) {
        this.employeeId = employeeId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Long getPhone() {
        return phone;
    }
    public void setPhone(Long phone) {
        this.phone = phone;
    }


    



}
