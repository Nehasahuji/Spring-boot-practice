package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Employee;
import com.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v1")
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@PostMapping("/employee")
	public Employee addEmployee(@RequestBody Employee employee) {
		return employeeService.AddEmployee(employee);
	}

	@GetMapping("/employees")
	public List<Employee> showAllEmplyoee() {
		return employeeService.ShowAllEmployee();
	}

	@GetMapping("/employee/{id}")
	public Object findEmployeeById(@PathVariable("id") long id) {
		return employeeService.findEmployeeById(id);
	}

	@PutMapping("employee/{id}/{salary}")
	public Object updateSalary(@PathVariable("id") long id, @PathVariable("salary") float salary) {
		return employeeService.findSalary(id, salary);
	}
}
