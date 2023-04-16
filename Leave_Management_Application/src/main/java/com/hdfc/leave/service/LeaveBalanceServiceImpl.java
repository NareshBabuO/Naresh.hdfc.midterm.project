package com.hdfc.leave.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdfc.leave.DTO.LeaveBalanceDTO;
import com.hdfc.leave.entity.LeaveBalance;
import com.hdfc.leave.enums.LeaveType;
import com.hdfc.leave.exception.LeaveBalanceNotFoundException;
import com.hdfc.leave.repository.EmployeeRepository;
import com.hdfc.leave.repository.LeaveBalanceRepository;

@Service
public class LeaveBalanceServiceImpl implements LeaveBalanceService {

	@Autowired
	LeaveBalanceRepository leaveBalanceRepo;

	@Autowired
	EmployeeRepository employeeRepo;

	@Override
	public LeaveBalance AddBalance(LeaveBalanceDTO lbDTO) {

		// Employees employees = new Employees();

		// employees.setEmployee_id(lbDTO.getEmployee().getEmployee_id());

		LeaveBalance balance = new LeaveBalance();

		balance.setLeaveBalanceId(lbDTO.getLeaveBalanceId());
		balance.setEmployee(lbDTO.getEmployee());
		balance.setLeaveType(lbDTO.getLeaveType());
		balance.setBalance(lbDTO.getBalance());

		return leaveBalanceRepo.save(balance);
	}

	/*
	 * @Override public LeaveBalance UpdateBalanceById(LeaveBalanceDTO
	 * leaveBalanceId) {
	 * 
	 * LeaveBalance balance = new LeaveBalance();
	 * 
	 * // .balance. employees = new Employees();
	 * 
	 * // employees.setEmployee_id(leaveBalanceId.getEmployee().getEmployee_id());
	 * 
	 * balance.setLeaveBalanceId(leaveBalanceId.getLeaveBalanceId());
	 * balance.setEmployee(leaveBalanceId.getEmployee());
	 * balance.setLeaveType(leaveBalanceId.getLeaveType());
	 * balance.setBalance(leaveBalanceId.getBalance());
	 * 
	 * return repo.save(leaveBalanceId); }
	 */

	@Override
	public List<LeaveBalance> getAllBalance() {
		return leaveBalanceRepo.findAll();
	}

	@Override
	@Transactional
	public List<LeaveBalance> getBalanceByEmpId(long employee_id) throws LeaveBalanceNotFoundException {

		List<LeaveBalance> findByEmployeeId = leaveBalanceRepo.findByEmployeeId(employee_id);
		if (findByEmployeeId.isEmpty()) {
			throw new LeaveBalanceNotFoundException("Leave balance not found for employee with ID: " + employee_id);
		}
		return findByEmployeeId;
	}

	@Override
	@Transactional
	public LeaveBalance getLeaveByEmpAndLeaveType(long employee_id, LeaveType leaveType) {

		return leaveBalanceRepo.getLeaveByEmpAndLeaveType(employee_id, leaveType);

	}

	/*
	 * @Override public void deleteBalanceById(long leaveBalanceId) {
	 * repo.deleteById(leaveBalanceId); }/
	 * 
	 * /*
	 * 
	 * @Override
	 * 
	 * @Transactional public LeaveBalance updateBalance(long leaveRequestId, int
	 * balance, LeaveType leaveType) {
	 * 
	 * LeaveBalance leaveBalance = getBalanceById(leaveRequestId);
	 * leaveBalance.setBalance(balance); leaveBalance.setLeaveType(leaveType);
	 * 
	 * return repo.save(leaveBalance); }
	 */

	@Override
	public LeaveBalance getBalanceById(long leaveBalanceId) throws LeaveBalanceNotFoundException {

		if (leaveBalanceRepo.existsById(leaveBalanceId)) {
			throw new LeaveBalanceNotFoundException("Leave Balance Not Found With :" + leaveBalanceId);
		}

		return leaveBalanceRepo.findById(leaveBalanceId).orElse(null);

	}

	@Override
	public LeaveBalance updateLeaveBalance(long leaveBalanceId, int balance) throws LeaveBalanceNotFoundException {

		LeaveBalance leaveBalance = getBalanceById(leaveBalanceId);
		leaveBalance.setBalance(balance);
		return leaveBalanceRepo.save(leaveBalance);
	}

	@Override
	@Transactional
	public Integer getAllLeaveByEmpID(long employee_id) throws LeaveBalanceNotFoundException {

		Integer allLeaveByEmpID = leaveBalanceRepo.getAllLeaveByEmpID(employee_id);

		if (allLeaveByEmpID == null || allLeaveByEmpID == 0) {
			throw new LeaveBalanceNotFoundException("No leave found for employee with ID: " + employee_id);
		}
		return allLeaveByEmpID;
	}

	@Override
	public LeaveBalance updateBalanceIfEmployeeAbsent(long employee_id) throws LeaveBalanceNotFoundException {

		LeaveBalance balance = getLeaveByEmpAndLeaveType(employee_id, LeaveType.CASUALLEAVE);

		return updateLeaveBalance(balance.getLeaveBalanceId(), balance.getBalance() - 1);

		
		
		
		
		
		
		
		
		
		
		
	}

}
