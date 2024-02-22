package com.example.crud1.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EmployeesEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id;
	private long PhoneNumber;
	private String Name;
	private String Department;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public long getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(long phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public String getDepartment() {
		return Department;
	}
	public void setDepartment(String department) {
		Department = department;
	}
	public EmployeesEntity(long id, long phoneNumber, String name, String department) {
		super();
		this.id = id;
		PhoneNumber = phoneNumber;
		Name = name;
		Department = department;
	}
	public EmployeesEntity() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "EmployeesEntity [id=" + id + ", PhoneNumber=" + PhoneNumber + ", Name=" + Name + ", Department="
				+ Department + "]";
	
	
	
	}
}
