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

		Employees emp = new Employees();
		emp.setEmployee_id(employeesDTO.getEmployee_id());
		emp.setName(employeesDTO.getName());
		emp.setEmail(employeesDTO.getEmail());
		emp.setPhone_number(employeesDTO.getPhone_number());
		emp.setDepartment(employeesDTO.getDepartment());
		return repo.save(emp);
	}

	@Override
	public List<Employees> findByName(String name) {
		return repo.findByName(name);
	}

	@Override
	public Employees updateEmployee(EmployeesDTO employeesDTO) {
		Employees emp = new Employees();
		emp.setEmployee_id(employeesDTO.getEmployee_id());
		emp.setName(employeesDTO.getName());
		emp.setEmail(employeesDTO.getEmail());
		emp.setPhone_number(employeesDTO.getPhone_number());
		emp.setDepartment(employeesDTO.getDepartment());
		return repo.save(emp);
	}

	@Override
	public void deleteById(long employee_id) {
		repo.deleteById(employee_id);
		
	}

}
