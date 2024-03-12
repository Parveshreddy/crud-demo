package com.example.crud1.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud1.Entity.EmployeesEntity;
import com.example.crud1.repo.EmployeesRepository;

@Service
public class EmployeeService implements Employees {

    @Autowired
    private EmployeesRepository employeesRepository;

    @Override
    public EmployeesEntity saveEmployee(EmployeesEntity employee) {
        return employeesRepository.save(employee);
    } 

    @Override
    public List<EmployeesEntity> getAllEmployees() {
        return employeesRepository.findAll();
    }
    @Override
    public List<EmployeesEntity> getEmployeesByName(String name) {
    Optional<EmployeesEntity> employeeName = employeesRepository.findByName(name);
    return employeeName.map(Collections::singletonList).orElse(Collections.emptyList());
}
    @Override
    public Optional<EmployeesEntity> getEmployeeById(long employeeId) {
        return employeesRepository.findById(employeeId);
    }

    @Override
    public void deleteEmployee(EmployeesEntity employee) {
        employeesRepository.delete(employee);
    }
}
