package com.amanpreet.springrest.service;

import java.util.List;

import com.amanpreet.springrest.entity.Employee;

public interface EmployeeService {
	
	public List<Employee> findAll();
	public Employee findById(int id);
	public void insert(Employee employee);
	public void deleteById(int id);

}
