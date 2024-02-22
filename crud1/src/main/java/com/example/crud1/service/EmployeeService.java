package com.example.crud1.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.crud1.Entity.EmployeesEntity;
import com.example.crud1.repo.EmployeesRepository;
@Service
public class EmployeeService {
	 @Autowired
	    private EmployeesRepository employeesRepository;

	    public EmployeesEntity saveEmployee(EmployeesEntity employee) {
	        return employeesRepository.save(employee);
	    }

	    public List<EmployeesEntity> getAllEmployees() {
	        return employeesRepository.findAll();
	    }

	    public Optional<EmployeesEntity> getEmployeeById(long employeeId) {
	        return employeesRepository.findById(employeeId);
	    }
	    public EmployeesEntity save(EmployeesEntity employeesEntity) {
			
			return employeesRepository.save(employeesEntity);
	    }

	    public void deleteEmployee(EmployeesEntity employee) {
	        employeesRepository.delete(employee);
	    }

		
	}
