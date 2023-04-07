package com.hdfc.leave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.leave.entity.Employees;
import com.hdfc.leave.repository.EmployeeRepository;
import com.hdfc.leave.service.EmployeeService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/l1/Employee")
public class EmployeeController {
	
	@Autowired
	EmployeeService service;
	
	@Autowired
	EmployeeRepository repo;

	@PostMapping("/AddEmp")
	public Employees saveEmployee(@Valid @RequestBody Employees employees) {
		return service.saveEmployee(employees);
	}

	@GetMapping("/getAll")
	public List<Employees> getAllEmployee() {
		return service.getAllEmployee();
	}

	


}
