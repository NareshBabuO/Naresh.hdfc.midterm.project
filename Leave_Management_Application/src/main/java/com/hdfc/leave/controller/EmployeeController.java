package com.hdfc.leave.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hdfc.leave.DTO.EmployeesDTO;
import com.hdfc.leave.entity.Employees;
import com.hdfc.leave.exception.EmployeeNotFoundException;
import com.hdfc.leave.exception.LeaveBalanceNotFoundException;
import com.hdfc.leave.service.EmployeeService;

@RestController
@RequestMapping("/Project/Employees")
public class EmployeeController {

	@Autowired
	EmployeeService service;

	@PostMapping("/AddEmp")
	public String addEmployee(@Valid @RequestBody EmployeesDTO employeesDTO) {
		service.addEmployee(employeesDTO);
		return "New Employeed Added:" + employeesDTO.getEmployee_id();
	}

	@GetMapping("/getAll")
	public List<Employees> getAllEmployee() {
		return service.getAllEmployee();
	}

	@GetMapping("/getByName/{name}")
	public List<Employees> findEmployeeByName(@PathVariable String name) throws EmployeeNotFoundException {
		List<Employees> findByName = service.findByName(name);

		return findByName;
	}

	@DeleteMapping("/delete/{employee_id}")
	public ResponseEntity<String> deleteRequestById(@PathVariable long employee_id)
			throws LeaveBalanceNotFoundException, EmployeeNotFoundException {

		service.deleteById(employee_id);

		return new ResponseEntity<String>("record Deleted" + employee_id, HttpStatus.GONE);
	}
}
