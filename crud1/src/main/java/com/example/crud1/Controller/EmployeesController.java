package com.example.crud1.Controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.crud1.Entity.EmployeesEntity;
import com.example.crud1.exception.ExceptionFound;
import com.example.crud1.service.EmployeeService;


import jakarta.validation.Valid;
  
@RestController
@RequestMapping("/api/employees")  
public class EmployeesController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeesEntity> CreateEmployee(@RequestBody EmployeesEntity employeesEntity) {
        EmployeesEntity Employee = employeeService.saveEmployee(employeesEntity);
        return new ResponseEntity<>(Employee, HttpStatus.CREATED);
    } 

    @GetMapping 
    public ResponseEntity<List<EmployeesEntity>> getAllEmployees() {
        List<EmployeesEntity> employeesList = employeeService.getAllEmployees();
        return new ResponseEntity<>(employeesList, HttpStatus.OK);
    }

    @GetMapping("/Name")
    public ResponseEntity<List<EmployeesEntity>> getEmployeesByName(@RequestParam(name = "name") String name)throws ExceptionFound   {
        List<EmployeesEntity> employeesList = employeeService.getEmployeesByName(name);
        if (!employeesList.isEmpty()) {
            return new ResponseEntity<>(employeesList,HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeesEntity> updateEmployee(@PathVariable(value = "id") Long employeeId, @Valid @RequestBody EmployeesEntity employeeDetails) throws ExceptionFound {
        EmployeesEntity employee = employeeService.getEmployeeById(employeeId).orElseThrow(() -> new ExceptionFound("Employee not found for this id :: " + employeeId));
        employee.setName(employeeDetails.getName());
        employee.setDepartment(employeeDetails.getDepartment()); 
        employee.setPhoneNumber(employeeDetails.getPhoneNumber());
        final EmployeesEntity updatedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(updatedEmployee, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws ExceptionFound {
        EmployeesEntity employee = employeeService.getEmployeeById(employeeId).orElseThrow(() -> new ExceptionFound("Employee not found for this id :: " + employeeId));
        employeeService.deleteEmployee(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
