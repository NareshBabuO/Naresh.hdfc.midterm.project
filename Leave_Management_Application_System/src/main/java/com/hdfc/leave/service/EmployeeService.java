package com.hdfc.leave.service;

import java.util.List;

import com.hdfc.leave.DTO.EmployeesDTO;
import com.hdfc.leave.entity.Employees;

public interface EmployeeService {

	public Employees saveEmployee(EmployeesDTO employeesDTO);

	 public Employees updateEmployee(EmployeesDTO employeesDTO);

	public List<Employees> getAllEmployee();

	public List<Employees> findByName(String name);
}