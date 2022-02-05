package com.example.ProjectReactJs.service;

import java.util.List;

import com.example.ProjectReactJs.model.Employee;

public interface EmployeeService {
	
	Employee saveEmployee(Employee employee);
	List<Employee> getAllEmployee();
  Employee getEmployeeById(Long id);
   Employee updateEmployee(Employee employee ,Long id );
	
}
