package com.khan.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.khan.document.Employee;
import com.khan.service.EmployeeService;

@RestController
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@PostMapping(path = "/employee")
	public Employee createEmployee(@RequestBody Employee employee) {
		return employeeService.createEmployee(employee);
	}

	@GetMapping(path = "/employee/{id}")
	public Employee fetchEmployee(@PathVariable Integer id) {
		return employeeService.fetchEmployee(id);
	}

	@GetMapping(path = "/employees")
	public List<Employee> fetchEmployees(@RequestParam(required = false, value = "organisation") String organisation) {
		List<Employee> employees = null;
		if (organisation == null)
			employees = employeeService.fetchEmployees();
		else
			employees = employeeService.fetchEmployeeByOrganisation(organisation);
		return employees;
	}

	@DeleteMapping(path = "/employee/{id}")
	public void removeEmployee(@PathVariable Integer id) {
		employeeService.removeEmployee(id);
	}

}
