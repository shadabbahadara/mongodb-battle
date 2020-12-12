package com.khan.repository.mongodb;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.khan.document.Employee;

@Repository
public interface EmployeeRepository extends MongoRepository<Employee, Integer> {

	List<Employee> findByOrganisation(String organisation);

}
