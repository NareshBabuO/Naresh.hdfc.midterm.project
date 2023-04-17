package com.hdfc.leave.service;
/**
 *@author NareshBabu O
 *@created 09-April-2023
*
 */
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.leave.DTO.EmployeesDTO;
import com.hdfc.leave.DTO.LeaveBalanceDTO;
import com.hdfc.leave.entity.Employees;
import com.hdfc.leave.entity.LeaveBalance;
import com.hdfc.leave.enums.LeaveType;
import com.hdfc.leave.enums.insertType;
import com.hdfc.leave.exception.EmployeeNotFoundException;
import com.hdfc.leave.exception.LeaveBalanceNotFoundException;
import com.hdfc.leave.repository.EmployeeRepository;
import com.hdfc.leave.repository.LeaveBalanceRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository EmployeeRequestRepo;

	@Autowired
	LeaveBalanceService leavebalanceservice;

	@Autowired
	LeaveBalanceRepository leavebalanceRepo;

	@Override
	public List<Employees> getAllEmployee() {
		return EmployeeRequestRepo.findAll();
	}

	@Override
	public Employees addEmployee(EmployeesDTO employeesDTO) {

		Employees emp = new Employees();
		emp.setEmployee_id(employeesDTO.getEmployee_id());
		emp.setName(employeesDTO.getName());
		emp.setEmail(employeesDTO.getEmail());
		emp.setPhone_number(employeesDTO.getPhone_number());
		emp.setDepartment(employeesDTO.getDepartment());

		Employees addEmployee = EmployeeRequestRepo.save(emp);
		if (addEmployee != null) {

			LeaveBalanceDTO cl = new LeaveBalanceDTO();
			cl.setEmployee(addEmployee);
			cl.setLeaveType(LeaveType.CASUALLEAVE);
			cl.setBalance(cl.CASUALLEAVE = 14);

			LeaveBalanceDTO sl = new LeaveBalanceDTO();
			sl.setEmployee(addEmployee);
			sl.setLeaveType(LeaveType.SICKLEAVE);
			sl.setBalance(sl.SICKLEAVE = 12);

			LeaveBalanceDTO prl = new LeaveBalanceDTO();
			prl.setEmployee(addEmployee);
			prl.setLeaveType(LeaveType.PRIVILEGELEAVE);
			prl.setBalance(prl.PATERNITYLEAVE = 7);

			LeaveBalanceDTO ml = new LeaveBalanceDTO();
			ml.setEmployee(addEmployee);
			ml.setLeaveType(LeaveType.MATERNITYLEAVE);
			ml.setBalance(ml.MATERNITYLEAVE = 16);

			LeaveBalanceDTO ptl = new LeaveBalanceDTO();
			ptl.setEmployee(addEmployee);
			ptl.setLeaveType(LeaveType.PATERNITYLEAVE);
			ptl.setBalance(ptl.PATERNITYLEAVE = 14);

			leavebalanceservice.AddBalance(cl);
			insertType.info(cl);

			leavebalanceservice.AddBalance(sl);
			insertType.info(sl);

			leavebalanceservice.AddBalance(prl);
			insertType.info(prl);
			leavebalanceservice.AddBalance(ml);
			insertType.info(ml);
			leavebalanceservice.AddBalance(ptl);
			insertType.info(ptl);

		}
		return addEmployee;
	}

	@Override
	public List<Employees> findByName(String name) throws EmployeeNotFoundException {
		List<Employees> employees = EmployeeRequestRepo.findByName(name);

		if (employees.isEmpty()) {
			throw new EmployeeNotFoundException("No employees found with name: " + name);
		}

		return employees;
	}

	@Override
	public Employees updateEmployee(EmployeesDTO employeesDTO) {
		Employees emp = new Employees();

		emp.setEmployee_id(employeesDTO.getEmployee_id());
		emp.setName(employeesDTO.getName());
		emp.setEmail(employeesDTO.getEmail());
		emp.setPhone_number(employeesDTO.getPhone_number());
		emp.setDepartment(employeesDTO.getDepartment());
		return EmployeeRequestRepo.save(emp);
	}

	@Override
	public void deleteById(long employee_id) throws EmployeeNotFoundException, LeaveBalanceNotFoundException {

		if (!EmployeeRequestRepo.existsById(employee_id)) {
			throw new EmployeeNotFoundException("Employee Not Found to Delete with :" + employee_id);
		}

		List<LeaveBalance> list = leavebalanceservice.getBalanceByEmpId(employee_id);
		for (LeaveBalance balance : list) {

			leavebalanceRepo.delete(balance);
		}

		EmployeeRequestRepo.deleteById(employee_id);

	}
}
