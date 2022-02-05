package com.example.ProjectReactJs.service.serviceImpl;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.ProjectReactJs.exception.ResourceNoteFoundException;
import com.example.ProjectReactJs.model.Employee;
import com.example.ProjectReactJs.repository.EmployeeReposetry;
import com.example.ProjectReactJs.service.EmployeeService;

@Service
public class EmployeeServiceClass implements EmployeeService {
      
	@Autowired
	EmployeeReposetry employeeReposetry;
	
	


	public Employee saveEmployee(Employee employee) {
		// TODO Auto-generated method stub
		return employeeReposetry.save(employee);
	}
List<Employee> list;


@Override
public List<Employee> getAllEmployee() {
	// TODO Auto-generated method stub
	 return employeeReposetry.findAll();
}

@Override
public Employee getEmployeeById(Long id) {
	// TODO Auto-generated method stub
	
    Optional<Employee> employee = employeeReposetry.findById(id);
    if(employee.isPresent()) {
	return employee.get();
    }else {
    	throw new ResourceNoteFoundException("Employee", "id", id);
    }
}

@Override
public Employee updateEmployee(Employee employee, Long id) {
	
	Employee existingEmployee=employeeReposetry.findById(id).orElseThrow(
()->new ResourceNoteFoundException("Employee", "id", id));
	
	existingEmployee.setFirstname(employee.getFirstname());
	existingEmployee.setLastname(employee.getLastname());
	existingEmployee.setEmail(employee.getEmail());
	// save existing employee to data base call to reposetry for save 
	
	employeeReposetry.save(existingEmployee);
	return existingEmployee;
}
	

	
	
	
}


	

