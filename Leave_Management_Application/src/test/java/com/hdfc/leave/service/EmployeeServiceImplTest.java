package com.hdfc.leave.service;

/**
 *@author NareshBabu O
 *@created 16-April-2023
*
 */
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
		
		
		
		
		employeesDTO.setEmployee_id(1015);
		employeesDTO.setName("Venkatesh");
		employeesDTO.setEmail("venki33@gmail.com");
		employeesDTO.setPhone_number("+919984554382");
		employeesDTO.setDepartment("Developer");

		Employees addEmployee = employeeService.addEmployee(employeesDTO);
		assertNotNull(addEmployee);
	}

	@Test
	void testGetEmployeeByName() throws EmployeeNotFoundException {
		List<Employees> findByName = employeeService.findByName("Naresh Babu");
		assertNotNull(findByName);

	}

}
