package com.amanpreet.springrest.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.amanpreet.springrest.entity.Employee;
import com.amanpreet.springrest.service.EmployeeService;

@RestController
@RequestMapping("/api") 
public class EmployeeRestController {
	// inject employee dao
		private EmployeeService employeeService;

		@Autowired
		public EmployeeRestController(EmployeeService theEmployeeService) {
			employeeService = theEmployeeService;
		}

		// expose /employee and return list of employees
		@GetMapping("/employee")
		public List<Employee> findAll() {
			return employeeService.findAll();
		}

		// add mapping to get /employees/{employeeID}
		@GetMapping("/employee/{employeeId}")
		public Employee getEmployee(@PathVariable int employeeId) {
			Employee theEmployee = employeeService.findById(employeeId);

			if (theEmployee == null) {
				throw new RuntimeException(" Employee id not found");
			}
			return theEmployee;
		}

		// save is our post mapping
		@PostMapping("/employee")
		public Employee addEmployee(@RequestBody Employee theEmployee) {
			theEmployee.setId(0);
			employeeService.insert(theEmployee);
			return theEmployee;
		}

		// update employee we use PUT mapping
		@PutMapping("/employee")
		public Employee updateEmployee(@RequestBody Employee theEmployee) {
			employeeService.insert(theEmployee);
			return theEmployee;
		}

		// delete mapping

		@DeleteMapping("employee/{employeeId}")
		public String deleteEmployee(@PathVariable int employeeId) {

			Employee tempEmployee = employeeService.findById(employeeId);

			// throw exception if null
			if (tempEmployee == null) {
				throw new RuntimeException("employee not present");
			}
			employeeService.deleteById(employeeId);
			return "delete employee id " + employeeId;
		}
}
