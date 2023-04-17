package com.hdfc.leave.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.hdfc.leave.DTO.EmployeesDTO;
import com.hdfc.leave.entity.Employees;
import com.hdfc.leave.exception.EmployeeNotFoundException;
import com.hdfc.leave.repository.EmployeeRepository;

@SpringBootTest
class EmployeeServiceImplTest {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	EmployeeRepository employeeRepository;

	@Test
	void testAddEmployee() {

		EmployeesDTO employeesDTO = new EmployeesDTO();
		employeesDTO.setEmployee_id(1002);
		employeesDTO.setName("Nandini");
		employeesDTO.setEmail("nandini@gmail.com");
		employeesDTO.setPhone_number("+918767544745");
		employeesDTO.setDepartment("HR Team");

		Employees addEmployee = employeeService.
				addEmployee(employeesDTO);
		assertNotNull(addEmployee);
	}
	
	@Test
	void testGetEmployeeByName() throws EmployeeNotFoundException {
		List<Employees> findByName = 
				employeeService.findByName("Naresh Babu");
		assertNotNull(findByName);

	}

}
