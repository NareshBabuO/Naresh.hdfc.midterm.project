package com.hdfc.leave.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hdfc.leave.DTO.LeaveBalanceDTO;
import com.hdfc.leave.entity.LeaveBalance;
import com.hdfc.leave.enums.LeaveType;
import com.hdfc.leave.repository.LeaveBalanceRepository;

@Service
public class LeaveBalanceServiceImpl implements LeaveBalanceService {

	@Autowired
	LeaveBalanceRepository repo;

	@Override
	public LeaveBalance AddBalance(LeaveBalanceDTO lbDTO) {

		// Employees employees = new Employees();

		// employees.setEmployee_id(lbDTO.getEmployee().getEmployee_id());

		LeaveBalance balance = new LeaveBalance();

		balance.setLeaveBalanceId(lbDTO.getLeaveBalanceId());
		balance.setEmployee(lbDTO.getEmployee());
		balance.setLeaveType(lbDTO.getLeaveType());
		balance.setBalance(lbDTO.getBalance());

		return repo.save(balance);
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
		return repo.findAll();
	}

	@Override
	@Transactional
	public List<LeaveBalance> getBalanceByEmpId(long employee_id) {
		return repo.findByEmployeeId(employee_id);
	}

	@Override
	@Transactional
	public LeaveBalance getLeaveByEmpAndLeaveType(long employee_id, LeaveType leaveType) {

		return repo.getLeaveByEmpAndLeaveType(employee_id, leaveType);
	}

	@Override
	public void deleteBalanceById(long leaveBalanceId) {
		repo.deleteById(leaveBalanceId);
	}

	/*
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
	public LeaveBalance getBalanceById(long leaveBalanceId) {
		return repo.findById(leaveBalanceId).orElse(null);
	}

	@Override
	public LeaveBalance updateLeaveBalance(long leaveBalanceId, int balance) {

		LeaveBalance leaveBalance = getBalanceById(leaveBalanceId);
		leaveBalance.setBalance(balance);
		return repo.save(leaveBalance);
	}

}
