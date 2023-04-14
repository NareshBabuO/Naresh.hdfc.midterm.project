package com.hdfc.leave.service;

import java.util.List;

import com.hdfc.leave.DTO.LeaveBalanceDTO;
import com.hdfc.leave.entity.LeaveBalance;
import com.hdfc.leave.enums.LeaveType;

public interface LeaveBalanceService {

	public LeaveBalance AddBalance(LeaveBalanceDTO lbDTO);

	//public LeaveBalance UpdateBalanceById(LeaveBalanceDTO leaveBalanceId);

	public List<LeaveBalance> getBalanceByEmpId(long employee_id);

	public LeaveBalance getLeaveByEmpAndLeaveType(long employee_id, LeaveType leaveType);

	public void deleteBalanceById(long leaveBalanceId);

	public List<LeaveBalance> getAllBalance();

	public LeaveBalance getBalanceById(long leaveBalanceId);

//	public LeaveBalance updateBalance(long leaveRequestId, int balance, LeaveType leaveType);

	public LeaveBalance updateLeaveBalance(long leaveBalanceId, int balance);

}
