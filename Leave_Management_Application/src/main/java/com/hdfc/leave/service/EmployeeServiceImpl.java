package com.hdfc.leave.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.leave.DTO.EmployeesDTO;
import com.hdfc.leave.DTO.LeaveBalanceDTO;
import com.hdfc.leave.entity.Employees;
import com.hdfc.leave.entity.LeaveBalance;
import com.hdfc.leave.enums.LeaveType;
import com.hdfc.leave.enums.insertType;
import com.hdfc.leave.repository.EmployeeRepository;
import com.hdfc.leave.repository.LeaveBalanceRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository repo;

	@Autowired
	LeaveBalanceService lbservice;

	@Autowired
	LeaveBalanceRepository lbRepo;

	@Override
	public List<Employees> getAllEmployee() {
		return repo.findAll();
	}

	@Override
	public Employees addEmployee(EmployeesDTO employeesDTO) {

		Employees emp = new Employees();
		emp.setEmployee_id(employeesDTO.getEmployee_id());
		emp.setName(employeesDTO.getName());
		emp.setEmail(employeesDTO.getEmail());
		emp.setPhone_number(employeesDTO.getPhone_number());
		emp.setDepartment(employeesDTO.getDepartment());

		Employees addEmployee = repo.save(emp);
		if (addEmployee != null) {

			LeaveBalanceDTO cl = new LeaveBalanceDTO();
			cl.setEmployee(addEmployee);
			cl.setLeaveType(LeaveType.CASUALLEAVE);
			cl.setBalance(cl.CASUALLEAVE = 6);

			LeaveBalanceDTO sl = new LeaveBalanceDTO();
			sl.setEmployee(addEmployee);
			sl.setLeaveType(LeaveType.SICKLEAVE);
			sl.setBalance(sl.SICKLEAVE = 21);

			LeaveBalanceDTO prl = new LeaveBalanceDTO();
			prl.setEmployee(addEmployee);
			prl.setLeaveType(LeaveType.PRIVILEGELEAVE);
			prl.setBalance(prl.PATERNITYLEAVE = 7);

			LeaveBalanceDTO ml = new LeaveBalanceDTO();
			ml.setEmployee(addEmployee);
			ml.setLeaveType(LeaveType.MATERNITYLEAVE);
			ml.setBalance(ml.MATERNITYLEAVE = 26);

			LeaveBalanceDTO ptl = new LeaveBalanceDTO();
			ptl.setEmployee(addEmployee);
			ptl.setLeaveType(LeaveType.PATERNITYLEAVE);
			ptl.setBalance(ptl.PATERNITYLEAVE = 4);

			lbservice.AddBalance(cl);
			insertType.info(cl);

			lbservice.AddBalance(sl);
			insertType.info(sl);

			lbservice.AddBalance(prl);
			insertType.info(prl);
			lbservice.AddBalance(ml);
			insertType.info(ml);
			lbservice.AddBalance(ptl);
			insertType.info(ptl);

		}

		return addEmployee;

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

		List<LeaveBalance> list = lbservice.getBalanceByEmpId(employee_id);
		for (LeaveBalance balance : list) {

			lbRepo.delete(balance);
		}

		repo.deleteById(employee_id);

	}

}
