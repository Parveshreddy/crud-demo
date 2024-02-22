package com.example.crud1.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.crud1.Entity.EmployeesEntity;

public interface EmployeesRepository extends JpaRepository<EmployeesEntity ,Long> {

}
