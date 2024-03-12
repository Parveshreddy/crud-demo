package com.example.crud1.service;

import java.util.List;
import java.util.Optional;

import com.example.crud1.Entity.EmployeesEntity;

public interface Employees {
	public EmployeesEntity saveEmployee(EmployeesEntity employees);
    public List<EmployeesEntity> getAllEmployees();
    public List<EmployeesEntity> getEmployeesByName(String name);
    public Optional<EmployeesEntity> getEmployeeById(long employeeId);
    public  void deleteEmployee(EmployeesEntity employee);
}
 