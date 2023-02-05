package com.amanpreet.springrest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amanpreet.springrest.dao.EmployeeDao;
import com.amanpreet.springrest.entity.Employee;


@Service
public class EmployeeImpl implements EmployeeService{
	
	private EmployeeDao employeeDao;
	
	@Autowired
	private EmployeeImpl(EmployeeDao employeeDao) {
		this.employeeDao = employeeDao;
	}

	@Override
	public List<Employee> findAll() {
		return employeeDao.findAll();
	}

	@Override
	public Employee findById(int id) {
		return employeeDao.findById(id);
	}

	@Override
	public void insert(Employee employee) {
		employeeDao.insert(employee);
		
	}

	@Override
	public void deleteById(int id) {
		employeeDao.deleteById(id);
	}

}
