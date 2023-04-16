package com.hdfc.leave.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.hdfc.leave.DTO.EmployeesDTO;
import com.hdfc.leave.entity.Employees;

class EmployeeServiceTest {

	  private EmployeeService employeeService;

	    @BeforeEach
	    public void setUp() {
	        // initialize the employeeService instance
	        employeeService = new EmployeeServiceImpl();
	    }

	    @Test
	    public void testAddEmployee() {
	        EmployeesDTO employeesDTO = new EmployeesDTO();
	        employeesDTO.setName("John Doe");
	        employeesDTO.setEmail("john.doe@example.com");
	        employeesDTO.setPhone_number("123-456-7890");
	        employeesDTO.setDepartment("Sales");

	        Employees newEmployee = employeeService.addEmployee(employeesDTO);

	        assertNotNull(newEmployee);
	        assertEquals("John Doe", newEmployee.getName());
	        assertEquals("john.doe@example.com", newEmployee.getEmail());
	        assertEquals("123-456-7890", newEmployee.getPhone_number());
	        assertEquals("Sales", newEmployee.getDepartment());
	    }
	}
