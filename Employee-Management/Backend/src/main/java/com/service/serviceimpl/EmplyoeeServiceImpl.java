package com.service.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.entity.Employee;
import com.exception.EmployeeNotFoundException;
import com.repository.EmployeeRepository;
import com.service.EmployeeService;

@Service
public class EmplyoeeServiceImpl implements EmployeeService {
	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public Employee AddEmployee(Employee employee) {
		return employeeRepository.save(employee);
	}

	@Override
	public List<Employee> ShowAllEmployee() {
		return employeeRepository.findAll();
	}

	@Override
	public Optional<Employee> findEmployeeById(long id) {

		Optional<Employee> tempEmployee = employeeRepository.findById(id);

		if (tempEmployee.isEmpty()) {
			System.out.println(tempEmployee);
			throw new EmployeeNotFoundException("employee not found");
		}
		return tempEmployee;
	}

	@Override
	public Optional<Employee> findSalary(long id, float salary) {
		Optional<Employee> employee = this.findEmployeeById(id);
		employee.get().setSalary(salary);
		return employee;
	}
}
