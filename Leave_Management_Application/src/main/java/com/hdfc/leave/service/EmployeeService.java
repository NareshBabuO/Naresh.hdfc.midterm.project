package com.hdfc.leave.service;

import java.util.List;

import com.hdfc.leave.entity.Employees;

public interface EmployeeService {

	public Employees saveEmployee(Employees employees);

	//public Employees updateEmployee(Employees employees);

	public List<Employees> getAllEmployee();
	// List<Employees> findEmployeeByName(String name);
}
