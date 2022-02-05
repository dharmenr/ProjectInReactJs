package com.example.ProjectReactJs.repository;

import org.springframework.data.jpa.repository.JpaRepository;


import com.example.ProjectReactJs.model.Employee;


public interface EmployeeReposetry extends JpaRepository<Employee, Long>{

	
}
