package com.amanpreet.springrest.rest;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amanpreet.springrest.entity.Employee;
import com.amanpreet.springrest.service.EmployeeService;

@RestController
@RequestMapping("/api") 
public class EmployeeRestController {
	private EmployeeService  employeeServive;

	public EmployeeRestController(EmployeeService employeeServive) {
		super();
		this.employeeServive = employeeServive;
	}
	 
	 
	@GetMapping("/employee}")
	public List<Employee> findAll() {
		return employeeServive.findAll();
		
	}
	
	@GetMapping("/employee/{employeeId}")
	public Employee getEmployee() {
		return null;
		
	}
}
