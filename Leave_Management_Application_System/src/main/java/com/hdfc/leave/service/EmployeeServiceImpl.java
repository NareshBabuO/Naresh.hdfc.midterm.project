package com.hdfc.leave.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.leave.DTO.EmployeesDTO;
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
	public Employees saveEmployee(EmployeesDTO employeesDTO) {
		// TODO Auto-generated method stub

		Employees emp = new Employees();

		emp.setEmployeeId(employeesDTO.getEmployeeId());
		emp.setName(employeesDTO.getName());
		emp.setEmail(employeesDTO.getEmail());
		emp.setPhoneNumber(employeesDTO.getPhoneNumber());
		emp.setDepartment(employeesDTO.getDepartment());

		return repo.save(emp);

	}

	@Override
	public List<Employees> findByName(String name) {

		return repo.findByName(name);
	}

	@Override
	public Employees updateEmployee(EmployeesDTO employeesDTO) {
		Employees emp1 = new Employees();

		emp1.setEmployeeId(employeesDTO.getEmployeeId());
		emp1.setName(employeesDTO.getName());
		emp1.setEmail(employeesDTO.getEmail());
		emp1.setPhoneNumber(employeesDTO.getPhoneNumber());
		emp1.setDepartment(employeesDTO.getDepartment());
		return repo.save(emp1);

	}

}
