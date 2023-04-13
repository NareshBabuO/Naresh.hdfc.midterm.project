package com.hdfc.leave.service;

import java.util.List;

import com.hdfc.leave.DTO.LeaveBalanceDTO;
import com.hdfc.leave.entity.LeaveBalance;

public interface LeaveBalanceService {

	public LeaveBalance AddBalance(LeaveBalanceDTO lbDTO);

	public LeaveBalance UpdateBalanceById(LeaveBalanceDTO leaveBalanceId);

	public List<LeaveBalance> getBalanceByEmpId(long employee_id);
	
	
	public void deleteBalanceById(long leaveBalanceId);
	
	public List<LeaveBalance> getAllBalance();

}
