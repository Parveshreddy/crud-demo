package com.example.crud1.repo;


import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.crud1.Entity.EmployeesEntity;
@Repository
public interface EmployeesRepository extends JpaRepository<EmployeesEntity ,Long> {

	Optional<EmployeesEntity> findByName(String name);

}
