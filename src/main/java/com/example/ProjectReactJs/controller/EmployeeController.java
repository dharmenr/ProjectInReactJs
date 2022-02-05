package com.example.ProjectReactJs.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ProjectReactJs.model.Employee;
import com.example.ProjectReactJs.service.EmployeeService;
import com.example.ProjectReactJs.service.serviceImpl.EmployeeServiceClass;

@RestController
@RequestMapping("/employee")
public class EmployeeController {
	
	@Autowired
	EmployeeServiceClass employeeServiceClass;
	
	@GetMapping("/home")
	public String home() {
		return "Wlecome in REST API ";
	}
	

	// build create employee REST API
    @PostMapping
	 public ResponseEntity<Employee> saveEmployee(@RequestBody Employee employee){
		return new ResponseEntity<Employee>(employeeServiceClass.saveEmployee(employee), HttpStatus.CREATED);
		
		   }
    // get mapping for get employee 
    @GetMapping
    List<Employee> getEmployee(){
		return this.employeeServiceClass.getAllEmployee();
    	
    }
    
   @GetMapping("{id}")
    Employee getEmployeeById(@PathVariable("id") long empID){
	 
	return this.employeeServiceClass.getEmployeeById(empID);  
	  // return new ResponseEntity<Employee>( employeeServiceClass.getEmployeeById( id), HttpStatus.OK);   
   }
   
   @PutMapping("{id}")
   Employee updateEmployee(@PathVariable("id") Long id, @RequestBody Employee employee ) {
	   
	return employeeServiceClass.updateEmployee(employee, id);
	   
   }
   
}
