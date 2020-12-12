package com.khan.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.khan.document.Employee;
import com.khan.exception.NotFoundException;
import com.khan.repository.mongodb.EmployeeRepository;

@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Employee createEmployee(Employee employee) {
		return employeeRepository.insert(employee);
	}

	public List<Employee> fetchEmployees() {
		return employeeRepository.findAll();
	}

	public Employee fetchEmployee(Integer id) {
		Optional<Employee> employee = employeeRepository.findById(id);
		if (!employee.isPresent()) {
			throw new NotFoundException("Employee" + id + "does not exist in the database");
		}
		return employee.get();
	}

	public void removeEmployee(Integer id) {
		employeeRepository.deleteById(id);
	}

	public List<Employee> fetchEmployeeByOrganisation(String firstName) {
		return employeeRepository.findByOrganisation(firstName);
	}
}
