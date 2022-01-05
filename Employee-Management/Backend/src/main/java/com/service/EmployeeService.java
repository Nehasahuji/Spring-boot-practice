package com.service;

import java.util.List;
import java.util.Optional;

import com.entity.Employee;

public interface EmployeeService {

	Employee AddEmployee(Employee employee);

	List<Employee> ShowAllEmployee();

	Optional<Employee> findEmployeeById(long id);

	Optional<Employee> findSalary(long id, float salary);
}
