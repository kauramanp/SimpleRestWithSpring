package com.amanpreet.springrest.dao;

import java.util.List;

import com.amanpreet.springrest.entity.Employee;

public interface EmployeeDao {
	
	public List<Employee> findAll();
	public Employee findById(int id);
	public void save(Employee employee);
	public void deleteById(int id);

}
