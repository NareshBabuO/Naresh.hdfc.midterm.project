package com.hdfc.leave.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.leave.DTO.EmployeesDTO;
import com.hdfc.leave.entity.Employees;
import com.hdfc.leave.exception.EmployeeNotFoundException;
import com.hdfc.leave.repository.EmployeeRepository;
import com.hdfc.leave.service.EmployeeService;

@RestController
@RequestMapping("/api/Employees")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@Autowired
	EmployeeRepository repo;

	@PostMapping("/AddEmp")
	public Employees saveEmployee(@Valid @RequestBody EmployeesDTO employeesDTO) {
		return service.saveEmployee(employeesDTO);
	}

	@GetMapping("/getAll")
	public List<Employees> getAllEmployee() {
		return service.getAllEmployee();
	}

	@GetMapping("/getByName/{name}")
	public List<Employees> findEmployeeByName(@PathVariable String name) throws EmployeeNotFoundException {

		List<Employees> findByName = service.findByName(name);

		if (name.isEmpty()) {
			throw new EmployeeNotFoundException("Employee Not Found " + name);
		}
		return findByName;
	}

}
