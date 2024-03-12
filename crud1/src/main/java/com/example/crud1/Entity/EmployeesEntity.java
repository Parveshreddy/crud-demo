package com.example.crud1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeesEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private long phoneNumber; 
    private String name;      
    private String department; 


    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public long getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(long phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public String getName() {
        return name;
    }
  
    public void setName(String name) {
        this.name = name;
    }
    public String getDepartment() {
        return department;
    }
    public void setDepartment(String department) {
        this.department = department;
    }
    public EmployeesEntity(long id, long phoneNumber, String name, String department) {
        super();
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.name = name;
        this.department = department;
    }
    public EmployeesEntity() {
        super();
    }
    @Override
    public String toString() {
        return "EmployeesEntity [id=" + id + ", phoneNumber=" + phoneNumber + ", name=" + name + ", department="
                + department + "]";
    }
}
