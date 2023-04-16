package com.hdfc.leave.service;

import java.util.List;

import com.hdfc.leave.DTO.LeaveBalanceDTO;
import com.hdfc.leave.entity.LeaveBalance;
import com.hdfc.leave.enums.LeaveType;
import com.hdfc.leave.exception.LeaveBalanceNotFoundException;

public interface LeaveBalanceService {

	public LeaveBalance AddBalance(LeaveBalanceDTO lbDTO);

	// public LeaveBalance UpdateBalanceById(LeaveBalanceDTO leaveBalanceId);

	public List<LeaveBalance> getBalanceByEmpId(long employee_id) throws LeaveBalanceNotFoundException;

	public LeaveBalance getLeaveByEmpAndLeaveType(long employee_id, LeaveType leaveType);

	public List<LeaveBalance> getAllBalance();

	public LeaveBalance getBalanceById(long leaveBalanceId) throws LeaveBalanceNotFoundException;

	public LeaveBalance updateLeaveBalance(long leaveBalanceId, int balance) throws LeaveBalanceNotFoundException;

	public Integer getAllLeaveByEmpID(long employee_id) throws LeaveBalanceNotFoundException;

	public LeaveBalance updateBalanceIfEmployeeAbsent(long employee_id) throws LeaveBalanceNotFoundException;

	// public LeaveBalance updateBalanceIfEmployeeAbsent(long leaveBalanceId, int
	// balance, LeaveType leaveType);

	// LeaveBalance updateBalanceIfEmployeeAbsent(long leaveBalanceId,int balance);
}
