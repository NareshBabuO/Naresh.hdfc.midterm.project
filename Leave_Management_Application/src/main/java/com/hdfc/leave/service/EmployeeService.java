package com.hdfc.leave.service;
/**
 *@author NareshBabu O
 *@created 07-April-2023
*
 */
import java.util.List;

import com.hdfc.leave.DTO.EmployeesDTO;
import com.hdfc.leave.entity.Employees;
import com.hdfc.leave.exception.EmployeeNotFoundException;
import com.hdfc.leave.exception.LeaveBalanceNotFoundException;

public interface EmployeeService {

	//public Employees addEmployee(EmployeesDTO employeesDTO, BindingResult result);
	public Employees addEmployee(EmployeesDTO employeesDTO);
	public List<Employees> getAllEmployee();

	public List<Employees> findByName(String name) throws EmployeeNotFoundException;

	public Employees updateEmployee(EmployeesDTO employeesDTO);

	public void deleteById(long employee_id) throws EmployeeNotFoundException, LeaveBalanceNotFoundException;

}
