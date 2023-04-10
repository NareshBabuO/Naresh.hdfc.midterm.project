package com.hdfc.leave.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hdfc.leave.DTO.LeaveBalanceDTO;
import com.hdfc.leave.entity.LeaveBalance;
import com.hdfc.leave.repository.LeaveBalanceRepository;

@Service
public class LeaveBalanceServiceImpl implements LeaveBalanceService {

	@Autowired
	LeaveBalanceRepository repo;

	@Override
	public LeaveBalance AddBalance(LeaveBalanceDTO lbDTO) {

		LeaveBalance balance = new LeaveBalance();
		balance.setLeaveBalanceId(lbDTO.getLeaveBalanceId());
		balance.setEmployee(lbDTO.getEmployee());
		balance.setLeaveType(lbDTO.getLeaveType());
		balance.setBalance(lbDTO.getBalance());

		return repo.save( balance);
	}

	@Override
	public LeaveBalance UpdateBalance(LeaveBalanceDTO lbDTO) {
		LeaveBalance balance = new LeaveBalance();
		balance.setLeaveBalanceId(lbDTO.getLeaveBalanceId());
		balance.setEmployee(lbDTO.getEmployee());
		balance.setLeaveType(lbDTO.getLeaveType());
		balance.setBalance(lbDTO.getBalance());

		return repo.save( balance);
	}

}
