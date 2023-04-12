package com.hdfc.leave.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.leave.DTO.LeaveBalanceDTO;
import com.hdfc.leave.entity.Employees;
import com.hdfc.leave.entity.LeaveBalance;
import com.hdfc.leave.repository.LeaveBalanceRepository;

@Service
public class LeaveBalanceServiceImpl implements LeaveBalanceService {

	@Autowired
	LeaveBalanceRepository repo;

	@Override
	public LeaveBalance AddBalance(LeaveBalanceDTO lbDTO) {

		Employees employees = new Employees();

		employees.setEmployee_id(lbDTO.getEmployee().getEmployee_id());

		LeaveBalance balance = new LeaveBalance();
		balance.setLeaveBalanceId(lbDTO.getLeaveBalanceId());
		balance.setEmployee(employees);
		balance.setLeaveType(lbDTO.getLeaveType());
		balance.setBalance(lbDTO.getBalance());

		return repo.save(balance);
	}

	@Override
	public LeaveBalance UpdateBalanceById(LeaveBalanceDTO leaveBalanceId) {
		LeaveBalance balance = new LeaveBalance();

		Employees employees = new Employees();

		employees.setEmployee_id(leaveBalanceId.getEmployee().getEmployee_id());

		balance.setLeaveBalanceId(leaveBalanceId.getLeaveBalanceId());
		balance.setEmployee(employees);
		balance.setLeaveType(leaveBalanceId.getLeaveType());
		balance.setBalance(leaveBalanceId.getBalance());
		return repo.save(leaveBalanceId);
	}

	@Override
	public List<LeaveBalance> getAllBalance() {
		return repo.findAll();
	}
}
