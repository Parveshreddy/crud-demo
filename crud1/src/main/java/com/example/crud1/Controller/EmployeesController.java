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
import org.springframework.web.bind.annotation.RestController;

import com.example.crud1.Entity.EmployeesEntity;
import com.example.crud1.exception.ExceptionFound;
import com.example.crud1.service.EmployeeService;


import jakarta.validation.Valid;




@RestController
public class EmployeesController {
	@Autowired
	EmployeeService employeeService;
	@PostMapping("/api/employees")
	public EmployeesEntity saveEmployee(@RequestBody EmployeesEntity employeesEntity) {
	    return employeeService.saveEmployee(employeesEntity);
	}


	@GetMapping("/api/employees")
	public List<EmployeesEntity> getAllEmployees() {
		//storing return type of Student Entity
		return employeeService.getAllEmployees();
	}
	@PutMapping("/api/employees/{id}")
	public ResponseEntity<EmployeesEntity> updateEmployee(@PathVariable(value = "id") Long employeeId,
	        @Valid @RequestBody EmployeesEntity employeeDetails) throws ExceptionFound {
	    EmployeesEntity employee = employeeService.getEmployeeById(employeeId)
	            .orElseThrow(() -> new ExceptionFound("Employee not found for this id :: " + employeeId));

	    employee.setName(employeeDetails.getName());
	    final EmployeesEntity updatedEmployee = employeeService.saveEmployee(employee);

	    return ResponseEntity.ok(updatedEmployee);
	}

	@DeleteMapping("/api/employees/{id}")
	public Map<Object, Object> deleteEmployee(@PathVariable(value = "id") Long employeeId) throws ExceptionFound {
	    EmployeesEntity employee = employeeService.getEmployeeById(employeeId)
	            .orElseThrow(() -> new ExceptionFound("Employee not found for this id :: " + employeeId));

	    employeeService.deleteEmployee(employee);

	    Map<Object, Object> response = new HashMap<>();
	    response.put("deleted", Boolean.TRUE);

	    return response;
	}


}

		
	


