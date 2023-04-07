package com.hdfc.leave.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.leave.entity.Employees;
import com.hdfc.leave.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Override
	public List<Employees> getAllEmployee() {
		return repo.findAll();
	}

	@Override
	public Employees saveEmployee(Employees employees) {
		return repo.save(employees);
	}

	/*
	 * @Override public Employees updateEmployee(Employees employees) { return
	 * repo.save(employees); }
	 */

}
