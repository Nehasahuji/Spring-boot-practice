package com.controller;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.entity.Employee;
import com.entity.ErrorMessage;
import com.service.EmployeeService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/v2")
public class EmployeeController2 {

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
		Optional<Employee> tempEmployee = employeeService.findEmployeeById(id);
		if (tempEmployee.isEmpty()) {

			ErrorMessage errorMessage = new ErrorMessage();
			errorMessage.setTimestamp(new Date());
			errorMessage.setMessage("employee not found " + id);

			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMessage);
		} else {
			System.out.println(tempEmployee + "employee found");
			return ResponseEntity.status(HttpStatus.OK).body(tempEmployee);
		}
	}

	@PutMapping("employee/{id}/{salary}")
	public Object updateSalary(@PathVariable("id") long id, @PathVariable("salary") float salary) {
		return employeeService.findSalary(id, salary);
	}
}
